/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
/**
 *
 * @author NikitaShokorov
 */
public class Lab7 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowRace(); 
            }
        });
    }

    private static void createAndShowRace() {
        JFrame f = new JFrame("Гоночки");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JPanel panel = new MyPanel();
        f.add(panel);
        f.pack();
        f.setVisible(true);
        f.setResizable(false);
    } 
}

class MyPanel extends JPanel {

    //Рандомчик
    final Random random = new Random();
    
    //Стартовая позиция по X
    private int startPos = 10;
    
    //Инициализируем тачки
    public Car orangeCar = new Car(startPos, 40, 255, 140, 0, random.nextInt(10) + 3, 1);
    public Car redCar = new Car(startPos, 70, 255, 0, 0, random.nextInt(10) + 3, 2);
    public Car blueCar = new Car(startPos, 100, 65, 105, 225, random.nextInt(10) + 3, 3);
    
    //Состояние гонки, false - как только одна из машин доедет до финиша
    public boolean racing = true;
    
    //Гонщики или пилоты (потоки)
    public Racer Schumacher;
    public Racer Senna;
    public Racer Kvyat;
    
    //Кнопка начинающая гонки
    private final JButton createTaskButton = new JButton("По машинам");

    //Конструктор панели
    public MyPanel() {
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setLayout(new BorderLayout());
        
        ActionListener listener = new MyActionListener();
        createTaskButton.addActionListener(listener);
        this.add(createTaskButton, BorderLayout.PAGE_END);
    }

    //Метод перемещающий болид
    public void moveCar(Car car) {
        if (car.getPosX() < 1000 - 55) {
            car.moveCar();
            repaint();
        } else {
            racing = false;
            Winner winnerWindow = new Winner("Тачка с номером " + car.getCarNumber() + " финишировала первой");
            createTaskButton.setText("Рестарт");
            this.setBackground(new Color(127,255,0));
        }
    }
    
    //Начало гонки, раздаем тачки
    public void startRace() {
        Schumacher = new Racer(orangeCar);
        Senna = new Racer(redCar);
        Kvyat = new Racer(blueCar);
        
        Schumacher.start();
        Senna.start();
        Kvyat.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000,200);
    }

    //Отрисовка
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString("Получается гоночки!",10,20);
        
        g.setColor(orangeCar.getCarColor());
        g.fillRect(orangeCar.getPosX(), orangeCar.getPosY(), orangeCar.getWidth(), orangeCar.getHeight());
        
        g.setColor(redCar.getCarColor());
        g.fillRect(redCar.getPosX(), redCar.getPosY(), redCar.getWidth(), redCar.getHeight());
        
        g.setColor(blueCar.getCarColor());
        g.fillRect(blueCar.getPosX(), blueCar.getPosY(), blueCar.getWidth(), blueCar.getHeight());
    }
    
    //Обработчик нажатия кнопки
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(racing) {
                startRace();
            } else {
                createTaskButton.setText("По машинам");
                orangeCar.onStart(startPos, random.nextInt(10) + 3);
                redCar.onStart(startPos, random.nextInt(10) + 3);
                blueCar.onStart(startPos, random.nextInt(10) + 3);
                repaint();
                racing = !racing;
                setBackground(null);
            }
        }
    }
    
    //Класс потока
    class Racer extends Thread {

        public Car car;
        
        Racer(Car car) {
            this.car = car;
        }

        @Override
        public void run() {
            try {
                while (racing) {
                    moveCar(car);
                    sleep(33);
                }
            } catch (Exception e) {
                   return;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diary;

/**
 *
 * @author NikitaShokorov
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TaskParams extends JFrame {
    //Подписи полей
    private JLabel lText, lTime, lImportance, lColor;
    //Кнопка отправки задачи
    private JButton setTaskButton;
    //Поле со списком
    JComboBox<String> JCHours,JCMinutes, JCImportance,JCColor;
    //поле для ввода текста задачи
    JTextArea jText;
    
    public TaskParams() {
        super("Создание задачи");
        setBounds(300, 300, 400, 400);
        
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        lText = new JLabel("Описание задачи");
        lText.setAlignmentX(CENTER_ALIGNMENT);
        lText.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        lTime = new JLabel("Время до конца");
        lTime.setAlignmentX(CENTER_ALIGNMENT);
        lTime.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        lImportance = new JLabel("Важность");
        lImportance.setAlignmentX(CENTER_ALIGNMENT);
        lImportance.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        lColor = new JLabel("Цвет фона");
        lColor.setAlignmentX(CENTER_ALIGNMENT);
        lColor.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        setTaskButton = new JButton("Добавить");
        setTaskButton.setAlignmentX(CENTER_ALIGNMENT);

        //Поле со списком
        String[] hours = new String[24];
        for(int i = 0; i < 24; i++)
            hours[i] = Integer.toString(i);
        String[] minutes = new String[60];
        for(int i = 0; i < 9; i++)
            minutes[i] = "0" + Integer.toString(i + 1);
        for(int i = 9; i < 60; i++)
            minutes[i] = Integer.toString(i + 1);
        JCHours = new JComboBox<>(hours);
        JCHours.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        JCMinutes = new JComboBox<>(minutes);

        String[] importance = new String []{"Важно", "Обычно", "Можно и не выполнять"};
        JCImportance = new JComboBox<>(importance);

        String[] colors = new String[]{"Белый", "Синий", "Розовый", "Зеленый", "Желтый"};
        JCColor = new JComboBox<>(colors);
        JCColor.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        jText = new JTextArea(); 
        jText.setPreferredSize(new Dimension(300,200));

        panel.add(lText); 
        panel.add(jText); 
        panel.add(lTime); 
        panel.add(JCHours); 
        panel.add(JCMinutes);
        panel.add(lImportance); 
        panel.add(JCImportance);  
        panel.add(lColor); 
        panel.add(JCColor);
        panel.add(setTaskButton);
        panel.add(Box.createVerticalStrut(10));
        getContentPane().add(panel);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        setResizable(true);
        setVisible(true);

        //Вытаскиваем введенные и выбраные параметры и создаем таск
        setTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textTask = jText.getText();
                String timeHour = JCHours.getSelectedItem().toString();
                String timeMinute = JCMinutes.getSelectedItem().toString();
                String strImp = JCImportance.getSelectedItem().toString();
                String strColor = JCColor.getSelectedItem().toString();

                Task task = new Task(textTask, timeHour, timeMinute, strImp, strColor);
            }
        });
    }
}

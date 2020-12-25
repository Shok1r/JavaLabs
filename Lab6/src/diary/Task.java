package diary;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author NikitaShokorov
 */
public class Task extends  JFrame{

    private JLabel lTask, lTime, lImportance, taskText;

    /**
     * с помощбю данных параметров формируется окно со всеми "полями" и параметрами
     * @param text  текст,который должен вывестись в окне с задачей
     * @param hours   время, часы
     * @param minutes время, минуты
     * @param importance важность
     * @param color цвет
     */
    public Task(String text, String hours, String minutes, String importance, String color){
        super("Задача");
        setBounds(300, 300, 400, 400);
        
        //Имитация верстки
        lTask = new JLabel("Задача: ");
        lTask.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lTime = new JLabel("Время до которого необходимо выполнить: \t" + hours + ":" + minutes);
        lTime.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        lImportance = new JLabel("Важность: \t" +  importance);
        lImportance.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        taskText = new JLabel(text);
        taskText.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

        JPanel panel = new JPanel();

        switch (color){
            case "Белый":
                panel.setBackground(Color.white);
                break;
            case "Синий":
                panel.setBackground(Color.blue);
                break;
            case "Розовый":
                panel.setBackground(Color.PINK);
                break;
            case "Зеленый":
                panel.setBackground(Color.GREEN);
                break;
            case "Желтый":
                panel.setBackground(Color.YELLOW);
                break;
        }

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lTask);
        panel.add(taskText);
        panel.add(lTime);
        panel.add(lImportance);
        getContentPane().add(panel);
        
        setResizable(true);
        setVisible(true);
    }
}

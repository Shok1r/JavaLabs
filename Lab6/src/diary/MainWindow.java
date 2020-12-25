package diary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {
    //кнопка для открытия окна с созданием задания
    private JButton createTaskButton = new JButton("Новое задание");

    //конструктор главного окна
    public MainWindow() {
        super("Ежедневник");

        setBounds(300, 300, 300, 90);
        createTaskButton.setPreferredSize(new Dimension(150,30));
        createTaskButton.addActionListener((ActionEvent e) -> {
            TaskParams taskParamsFrame = new TaskParams();
        });
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        createTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        container.add(createTaskButton);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Действие при выходе из программы
        setResizable(true);
        setVisible(true);
    }
}


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
     * � ������� ������ ���������� ����������� ���� �� ����� "������" � �����������
     * @param text  �����,������� ������ ��������� � ���� � �������
     * @param hours   �����, ����
     * @param minutes �����, ������
     * @param importance ��������
     * @param color ����
     */
    public Task(String text, String hours, String minutes, String importance, String color){
        super("������");
        setBounds(300, 300, 400, 400);
        
        //�������� �������
        lTask = new JLabel("������: ");
        lTask.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lTime = new JLabel("����� �� �������� ���������� ���������: \t" + hours + ":" + minutes);
        lTime.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        lImportance = new JLabel("��������: \t" +  importance);
        lImportance.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        taskText = new JLabel(text);
        taskText.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

        JPanel panel = new JPanel();

        switch (color){
            case "�����":
                panel.setBackground(Color.white);
                break;
            case "�����":
                panel.setBackground(Color.blue);
                break;
            case "�������":
                panel.setBackground(Color.PINK);
                break;
            case "�������":
                panel.setBackground(Color.GREEN);
                break;
            case "������":
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

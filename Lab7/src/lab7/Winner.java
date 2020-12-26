/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NikitaShokorov
 */
public class Winner extends  JFrame{
    private JLabel winner;

    public Winner(String text){
        super("Победитель");
        setBounds(100, 100, 400, 80);
        
        //Имитация верстки
        winner = new JLabel(text);
        winner.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(winner);
        getContentPane().add(panel);
        
        setResizable(false);
        setVisible(true);
    }
}


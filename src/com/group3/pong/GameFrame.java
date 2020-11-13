/**
* src: https://www.youtube.com/watch?v=oLirZqJFKPE&ab_channel=BroCode
* 
* The GameFrame program generates the program frame. 
* 
* @filename       GameFrame.java 
* @authors        psingh, nisht, gpabla
* @modified       20201112
* @since          20201105
* @version        1.0
*/
package com.group3.pong;

import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame{
    GamePanel panel; 
    JButton exitButton; 
    JPanel exitButtonPanel;
    
    
    ExitScreenHandler listener = new ExitScreenHandler(); 
    
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong!");
        this.setResizable(false);
        this.setBackground(new Color(7, 61, 150));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
        exitButton= new JButton("Exit");
        exitButton.setSize(100,200);
        exitButton.setBackground(Color.red);
        exitButton.setForeground(Color.CYAN);
        
        exitButton.addActionListener(listener);
        add(exitButton);
        panel.setVisible(true);             
    }

private class ExitScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GamePanel.scoreList.add(GamePanel.score.player1);
            dispose();
                Toolkit.getDefaultToolkit().beep(); 
                EndFrame frame = new EndFrame();
                panel.setVisible(true);
        }
    }
}
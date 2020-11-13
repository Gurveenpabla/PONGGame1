/**
* 
* The EndFrame program designs and generates the end screen. 
* 
* @filename       Score.java 
* @authors        psingh, nisht, gpabla
* @modified       20201112
* @since          20201105
* @version        1.0
*/
package com.group3.pong;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EndFrame extends JFrame {   
    JFrame window;
    Container c;
    JButton exitButton; 
    JButton playAgainButton; 
    JPanel titleNamePanel, playAgainPanel, exitButtonPanel, thankYouPanel; 
    JLabel titleNameLabel;
    JTextArea txtThanks; 
    Font newFont = new Font("Century Gothic", Font.PLAIN, 18);
    Font titleFont = new Font("Century Gothic", Font.PLAIN, 70);
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
       
    EndFrame() {   
        
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(7, 61, 150));
        window.setLayout(null);
       
        c = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 100);
        titleNamePanel.setBackground(new Color(7, 61, 150));
        titleNameLabel = new JLabel("PONG");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);  
        
        thankYouPanel = new JPanel();
        thankYouPanel.setBounds(100,220,575,150);
        thankYouPanel.setBackground(new Color(7, 61, 150));
        txtThanks = new JTextArea("Click Play Again to play another game or click Exit to leave!"); 
        txtThanks.setEditable(false);
        txtThanks.setBackground(new Color(7, 61, 155));
        txtThanks.setForeground(Color.white);
        txtThanks.setFont(newFont);    
    
        playAgainPanel = new JPanel();
        playAgainPanel.setBounds(150, 450, 300, 100);
        playAgainPanel.setBackground(new Color(7, 61, 150));
        
        playAgainButton = new JButton("PLAY AGAIN");
        playAgainButton.setBackground(Color.black);
        playAgainButton.setForeground(Color.white);
        playAgainButton.addActionListener(tsHandler);
                
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(250, 450, 500, 50);
        exitButtonPanel.setBackground(new Color(7, 61, 150));
        
        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(tsHandler);
       
        titleNamePanel.add(titleNameLabel);
        thankYouPanel.add(txtThanks);
        playAgainPanel.add(playAgainButton);
        exitButtonPanel.add(exitButton); 

        c.add(titleNamePanel);
        c.add(thankYouPanel);
        c.add(playAgainPanel);
        c.add(exitButtonPanel); 
      
       
        window.setVisible(true);     
    }

    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){  
            if (event.getSource() == exitButton) {
                JOptionPane.showMessageDialog(null, "Thanks for playing! So sad to see you leave :(");
                System.exit(0);
            }
            
            if (event.getSource() == playAgainButton) {
                GameFrame frame1 = new GameFrame();
                window.setVisible(false);     
                
            }     
        }
    }
}





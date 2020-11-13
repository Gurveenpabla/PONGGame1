/**
* 
* The Start program designs and generates the start screen. 
* 
* @filename       Start.java 
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
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
       
public class Start {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, closedButtonPanel, instructionPanel;
    JLabel titleNameLabel;
    JTextArea instructionArea;
    Font titleFont = new Font("Century Gothic", Font.PLAIN, 70);
    Font newFont = new Font("Century Gothic", Font.PLAIN, 18);
    JButton startButton, closedButton;   
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    CloseListener closed = new CloseListener();

    public static void main(String[] args) {
        new Start();
        File Clap = new File("music.wav");
        PlaySound(Clap);        
    }    
    
    public Start(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(7, 61, 150));
        window.setLayout(null);
       
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 100);
        titleNamePanel.setBackground(new Color(7, 61, 150));
        titleNameLabel = new JLabel("PONG");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        instructionPanel = new JPanel();
        instructionPanel.setBounds(100,220,575,150);
        instructionPanel.setBackground(new Color(7, 61, 150));
        instructionArea = new JTextArea("How to Play:" +"\n"
        +"- Press play to begin\t" +"\n" + "- Use the arrow keys to move the paddle vertically"+"\n"+ "- Click the screen to end the game"); 
        instructionArea.setEditable(false);
        instructionArea.setBackground(new Color(7, 61, 150));
        instructionArea.setForeground(Color.white);
        instructionArea.setFont(newFont);      
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(150, 450, 300, 100);
        startButtonPanel.setBackground(new Color(7, 61, 150));
      
        closedButtonPanel = new JPanel();
        closedButtonPanel.setBounds(250, 450, 500, 50);
        closedButtonPanel.setBackground(new Color(7, 61, 150));
        
        startButton = new JButton("PLAY");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.addActionListener(tsHandler);
               
        closedButton = new JButton("EXIT");
        closedButton.setBackground(Color.black);
        closedButton.setForeground(Color.white);
        closedButton.addActionListener(closed);
     
        titleNamePanel.add(titleNameLabel);
        instructionPanel.add(instructionArea);
     
        startButtonPanel.add(startButton);
        closedButtonPanel.add(closedButton);
        
        con.add(titleNamePanel);
        con.add(instructionPanel);
        con.add(startButtonPanel);
        con.add(closedButtonPanel);       
             
         window.setVisible(true);
    }
      
    public class TitleScreenHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            GameFrame frame = new GameFrame();
            window.setVisible(false);
        }
    }
    
    static void PlaySound(File Sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            
            Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch(Exception e){}
    }
  
    private class CloseListener implements ActionListener{
    @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}







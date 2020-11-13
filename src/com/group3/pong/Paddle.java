/**
* src: https://www.youtube.com/watch?v=oLirZqJFKPE&ab_channel=BroCode
* 
* The Paddle program defines the properties of the paddles. 
* 
* @filename       Paddle.java 
* @authors        psingh, nisht, gpabla
* @modified       20201112
* @since          20201105
* @version        1.0
*/
package com.group3.pong;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            setYDirection(-speed);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            setYDirection(speed);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            setYDirection(0);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            setYDirection(0);
        }
    }
    
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }
    
    public void move() {
        y= y + yVelocity;
    }
    
    public void draw(Graphics g) {
        if(id==1) {
            g.setColor(new Color(7, 61, 150));
        }
        else {
            g.setColor(new Color(215, 20, 30));
            g.fillRect(x, y, width, height);
        }
    }
}

/**
* src: https://www.youtube.com/watch?v=oLirZqJFKPE&ab_channel=BroCode
* 
* The Score program defines the properties of the score counter. 
* 
* @filename       Score.java 
* @authors        psingh, nisht, gpabla
* @modified       20201112
* @since          20201105
* @version        1.0
*/
package com.group3.pong;

import java.awt.*;

public class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
	
    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Century Gothic",Font.PLAIN,60));
        g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_WIDTH/2) - 20,65);
    }
}
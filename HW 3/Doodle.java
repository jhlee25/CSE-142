// Junhyoung Lee
// 4/21/20
// CSE 142
// TA: Aerin Malana
// Assignment #3
//
// This program will produce a train figure

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(400,300);
      panel.setBackground(Color.GREEN);
      Graphics g = panel.getGraphics();
      drawTrain(g);
   }
   
   //draw train with chimney, body, windows, wheels, and wheel connect bar
   public static void drawTrain(Graphics g) {
      //draw black chimney
      g.fillRect(270, 60, 40, 50);
      
      //draw gray body
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(70, 110, 240, 100);
      g.setColor(Color.BLACK);
      g.drawRect(70, 110, 240, 100);
      
      //draw red windows
      g.setColor(Color.RED);
      g.fillRect(250, 130, 60, 20);
      g.fillRect(90, 130, 130, 50);
      g.setColor(Color.BLACK);
      g.drawRect(250, 130, 60, 20);
      g.drawRect(90, 130, 130, 50);
      g.fillRect(290, 130, 20, 10);
      g.fillRect(90, 155, 130, 5);
      g.fillRect(130, 130, 5, 50);
      g.fillRect(175, 130, 5, 50);
      
      //draw 5 black wheels with red outline
      for (int i = 0; i < 5; i++) {
         g.setColor(Color.BLACK);
         g.fillOval(70 + 50 * i, 210, 40, 40);
         g.setColor(Color.RED);
         g.drawOval(70 + 50 * i, 210, 40, 40);
      }
      
      //draw gray wheel connect bar
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(70, 227, 240, 6);
      for (int i = 0; i < 5; i++) {
         g.setColor(Color.BLACK);
         g.fillOval(89 + 50 * i, 229, 2, 2);
      }
   }
}
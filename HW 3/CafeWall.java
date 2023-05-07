// Junhyoung Lee
// 4/21/20
// CSE 142
// TA: Aerin Malana
// Assignment #3
//
// This program will produce a given figure, Cafe Wall

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
   
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650,400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      singleRow(g, 0, 0, 4, 20);
      singleRow(g, 50, 70, 5, 30);
      
      grid(g, 10, 150, 4, 25, 0);
      grid(g, 250, 200, 3, 25, 10);
      grid(g, 425, 180, 5, 20, 10);
      grid(g, 400, 20, 2, 35, 35);
   }
   
   //draw single row
   public static void singleRow(Graphics g, int x, int y, int pairs, int size) {
      for (int i = 0; i < pairs; i++) {
         //draw black box
         g.setColor(Color.BLACK);
         g.fillRect(x + 2 * size * i, y, size, size);
         //draw white box
         g.setColor(Color.WHITE);
         g.fillRect(x + size * (1 + 2 * i), y, size, size);
         //draw blue diagonal lines
         g.setColor(Color.BLUE);
         g.drawLine(x + 2 * size * i, y, x + size * (1 + 2 * i), y + size);
         g.drawLine(x + 2 * size * i, y + size, x + size * (1 + 2 * i), y);
      }
   }
   
   //draw grid
   public static void grid(Graphics g, int x, int y, int pairs, int size, int offset) {
      //draw first pair of rows (1 pair = 2 rows)
      singleRow(g, x, y, pairs, size);
      singleRow(g, x + offset, y + size + MORTAR, pairs, size);
      //draw rest pairs of rows
      for (int i = 1; i <= pairs - 1; i++) {
         singleRow(g, x, y + 2 * (size + MORTAR) * i, pairs, size);
         singleRow(g, x + offset, y + (size + MORTAR) * (1 + 2 * i), pairs, size);
      }
   }
}

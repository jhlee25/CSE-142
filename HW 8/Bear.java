// Junhyoung Lee
// 6/4/20
// CSE 142
// TA: Aerin Malana
// Assignment #8
//
// This class represents the state and behavior of the Bear Critter

import java.awt.*;

public class Bear extends Critter {
   private int move;
   private boolean type; // type of bear color
   
   public Bear(boolean polar) {
      type = polar; // whether given parameter is polar or not
   }     
   
   // Returns the next move of the Bear, 
   // Will return infect if an enemy is in front
   // Will return hop if nothing is in front of you
   // Will return left if none of the other cases occur   
   public Action getMove(CritterInfo info) {
      move++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if(info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   // Returns the color of the Bear, which changes
   // to white if type is polar, otherwise to black
   public Color getColor() {
      if (type == true) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   // Returns the string representation of the Bear, which will
   // be slash and backslash back and forth
   public String toString() {
      if (move % 2 == 0) {
         return "/";
      } else {
         return "\\";
      }
   }
}
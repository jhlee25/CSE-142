// Junhyoung Lee
// 6/4/20
// CSE 142
// TA: Aerin Malana
// Assignment #8
//
// This class represents the state and behavior of the Giant Critter

import java.awt.*;

public class Giant extends Critter {
   private int move;
     
   // Returns the next move of the Giant, 
   // Will return infect if an enemy is in front
   // Will return hop if nothing is in front of you
   // Will return right if none of the other cases occur        
   public Action getMove(CritterInfo info) {
      move++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if(info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
   
   // Returns the color of the Giant, which will always be gray   
   public Color getColor() {
      return Color.GRAY;
   }
   
   // Returns the string representation of the Giant, which changes
   // into fee, fie, foe, and fum in every 6 move
   public String toString() {
      String[] name = {"fee", "fie", "foe", "fum"};
      if ((move / 6) < name.length) {
         return name[move / 6];
      } else {
         move = 0;
         return name[move / 6];
      }
   }
}
// Junhyoung Lee
// 6/4/20
// CSE 142
// TA: Aerin Malana
// Assignment #8
//
// This class represents the state and behavior of the Husky Critter

import java.awt.*;

public class Husky extends Critter {
   private int move;
     
   // Returns the next move of the Husky, 
   // Will return infect if an enemy is in front
   // Will return left if enemy facing you to your left
   // Will return right if none of the other cases occur   
   public Action getMove(CritterInfo info) {
      move++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else {
         if (info.leftThreat() == true) {
            return Action.LEFT;
         } else {
            return Action.RIGHT;
         }
      }
   }
   
   // Returns the color of the Husky, which will always be yellow
   public Color getColor() {
       return Color.YELLOW;
   }
   
   // Returns the string representation of the Husky, which changes
   // in every movement into its spelling
   public String toString() {
      String[] name = {"H", "U", "S", "K", "Y"};
      if (move < name.length) {
         return name[move];
      } else {
         move = 0;
         return name[move];
      }
   }
}
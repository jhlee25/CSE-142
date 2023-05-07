// Junhyoung Lee
// CSE 142
//
// This class represents the state and behavior of the JunHusky Critter

import java.awt.*;

public class JunHusky extends Critter {
   private int move;
     
   // Returns the next move of the JunHusky, 
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
   
   // Returns the color of the JunHusky, which will always be yellow
   public Color getColor() {
       return Color.YELLOW;
   }
   
   // Returns the string representation of the JunHusky, which changes
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
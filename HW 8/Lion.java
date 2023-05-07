// Junhyoung Lee
// 6/4/20
// CSE 142
// TA: Aerin Malana
// Assignment #8
//
// This class represents the state and behavior of the Lion Critter

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   private Random r;
   private int move;
   private int num; // the random number among 0, 1, and 2
   
   public Lion() {
      r = new Random();
      // gives you the first random number that used for 3 movement
      num = r.nextInt(3); 
   }
   
   // Returns the next move of the Lion, 
   // Will return infect if an enemy is in front
   // Will return left if wall is in front of you or in your right
   // Will return right if same critter is in front of you
   // Will return hop if none of the other cases occur          
   public Action getMove(CritterInfo info) {
      move++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || 
                info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if(info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   // Returns the color of the Lion, which changes in
   // every movement as random color among red, green, and blue
   public Color getColor() {
      Color[] result = {Color.RED, Color.GREEN, Color.BLUE};
      if (move < 3) {
         return result[num];   
      } else {
         move = 0;
         // gives you second and higher sequence of random number
         num = r.nextInt(3); 
         return result[num];
      }   
   }
   
   // Returns the string representation of the Lion, which will alays "L"
   public String toString() {
      return "L";
   }
}
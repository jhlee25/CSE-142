// Junhyoung Lee
// 5/19/20
// CSE 142
// TA: Aerin Malana
// Assignment #6
//
// This program gives a prompt to user to ask a name and sex combination and will read through
// the data file searching for that combination. If it finds it, it should graph the data for that combination. 
// If not, it should generate a short message indicating that the combination is not found.

import java.io.*;
import java.awt.*;
import java.util.*;

public class Names {
   public static final int DECADES = 14;
   public static final int START = 1880;
   public static final int WIDTH = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
      giveIntro();
      // prompt to user for name and sex combination
      System.out.print("name? ");
      String name = console.next().toLowerCase();
      System.out.print("sex (M or F)? ");
      String sex = console.next().toLowerCase();
      // using the combination, find a line that matches and graph the data
      String line = find(input, name, sex);
      if (line.length() > 0) {
         draw(line);
      } else {
         System.out.println("name/sex combination not found");
      }
   }
   
   // introduce the program to the user
   public static void giveIntro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START + ".");
      System.out.println();
   }
   
   // searches for matched data from provided input file using name and sex combination
   // returns the matched line, or returns empty string if not found
   public static String find(Scanner input, String name, String sex) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner data = new Scanner(line);
         String exatName = data.next();
         if (exatName.toLowerCase().equals(name) && line.toLowerCase().contains(sex)) {
            return line;
         }
      }
      return "";
   }
   
   // uses a DrawPanel to draw the graph with provided line
   public static void draw(String line) {
      DrawingPanel panel = new DrawingPanel(DECADES * WIDTH, 550);
      Graphics g = panel.getGraphics();
      // draw outline for the graph
      g.drawLine(0, 25, DECADES * WIDTH, 25);
      g.drawLine(0, 525, DECADES * WIDTH, 525);
      for (int i = 0; i < DECADES; i++) {
         g.drawLine(i * WIDTH, 0, i * WIDTH, 550);
      }
      for (int i = 0; i < DECADES; i++) {
         g.drawString("" + (START + 10 * i), i * WIDTH, 550);
      }
      // plot the data using provided line
      Scanner data = new Scanner(line);
      String name = data.next();
      String sex = data.next();
      g.setColor(Color.RED);
      // set the first y coordinate and draw the first text (fenceposting)
      int rank = data.nextInt();
      int lastY = modify(rank);
      g.drawString(name + " " + sex + " " + rank, 0, lastY);
      // draw rest of the graph
      for (int i = 0; i < DECADES - 1; i++) {
         int nextRank = data.nextInt();
         int y = modify(nextRank);
         g.drawLine(i * WIDTH, lastY, (i + 1) * WIDTH, y);
         g.drawString(name + " " + sex + " " + nextRank, (i + 1) * WIDTH, y);
         lastY = y;
      }
   }
   
   // use the provided rank value to modify as y-coordinate value
   public static int modify(int rank) {
      if (rank % 2 != 0) {
         return rank / 2 + 25;
      } else {
         if (rank == 0) {
            return 525;
         } else {
            return (rank - 1) / 2 + 25;
         }
      }
   }
}

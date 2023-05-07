// Junhyoung Lee
// 4/15/20
// CSE 142
// TA: Aerin Malana
// Assignment #2
//
// This program will produce an ASCII art that I cerated as the output

public class AsciiArt {
   public static void main(String[] args) {
      drawTop();
      drawLine();
      drawBodyTop();
      drawBodyBottom();
      drawLine();
   }
   
   //outputs a top
   public static void drawTop() {
      System.out.println("     ----     ");
      System.out.println("    |    |    ");
   }
   
   //outputs a line
   public static void drawLine() {
      for (int i = 1; i <= 4; i++) {
         System.out.print("-");
      }
      for (int i = 1; i <= 6; i++) {
         System.out.print(" ");
      }
      for (int i = 1; i <= 4; i++) {
         System.out.print("-");
      }
      System.out.println();
   }
   
   //outputs a top half of the body
   public static void drawBodyTop() {
      for (int line = 1; line <= 3; line++) {
         System.out.print("|");
         for (int spaces = 1; spaces <= (-2*line+7); spaces++) {
            System.out.print(" ");
         }
         for (int arrow = 1; arrow <= (2*line-1); arrow++) {
            System.out.print("<>");
         }
         for (int spaces = 1; spaces <= (-2*line+7); spaces++) {
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
   
   //outputs a bottom half of the body
   public static void drawBodyBottom() {
      for (int line = 3; line >= 1; line--) {
         System.out.print("|");
         for (int spaces = 1; spaces <= (-2*line+7); spaces++) {
            System.out.print(" ");
         }
         for (int arrow = 1; arrow <= (2*line-1); arrow++) {
            System.out.print("<>");
         }
         for (int spaces = 1; spaces <= (-2*line+7); spaces++) {
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
}
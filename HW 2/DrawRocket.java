// Junhyoung Lee
// 4/15/20
// CSE 142
// TA: Aerin Malana
// Assignment #2
//
// This program will produce and given Rocket Ship figure as the output

public class DrawRocket {
   public static final int SIZE = 3;
   
   public static void main(String[] args) {
      head();
      line();
      bodyTop();
      bodyBottom();
      line();
      bodyBottom();
      bodyTop();
      line();
      head();
   }
   
   //outputs a head of the rocket
   public static void head() {
      for (int line = 1; line <= (2 * SIZE - 1); line++) {
         for (int spaces = 1; spaces <= (-1 * line + 2 * SIZE); spaces++) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int backSlash = 1; backSlash <= line; backSlash++) {
            System.out.print("\\");
         }
         for (int spaces = 1; spaces <= (-1 * line + 2 * SIZE); spaces++) {
            System.out.print(" ");
         }
         System.out.println();
      }
   }
   
   //outputs a solid line
   public static void line() {
      System.out.print("+");
      for (int i = 1; i <= (2 * SIZE); i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   //outputs a top half of the body
   public static void bodyTop() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         for (int cone = 1; cone <= (line); cone++) {
            System.out.print("/\\");
         }
         for (int dotMiddle = 1; dotMiddle <= (-2 * line + 2 * SIZE); dotMiddle++) {
            System.out.print(".");
         }
         for (int cone = 1; cone <= (line); cone++) {
            System.out.print("/\\");
         }
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   //outputs a bottom half of the body
   public static void bodyBottom() {
      for (int line = SIZE; line >= 1; line--) {
         System.out.print("|");
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         for (int cone = 1; cone <= (line); cone++) {
            System.out.print("\\/");
         }
         for (int dotMiddle = 1; dotMiddle <= (-2 * line + 2 * SIZE); dotMiddle++) {
            System.out.print(".");
         }
         for (int cone = 1; cone <= (line); cone++) {
            System.out.print("\\/");
         }
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
}
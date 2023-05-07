// Junhyoung Lee
// 5/25/20
// CSE 142
// TA: Aerin Malana
// Assignment #7
//
// This program processes an input file of data for personality test in order to compute the score and
// overall result for each person. Then it will report these information to an output file.

import java.io.*;
import java.util.*;

public class Personality {
   public static final int DIMENSIONS = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      intro();
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.nextLine()));
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.nextLine()));
      while (input.hasNextLine()) {
         String name = input.nextLine();
         String data = input.nextLine();
         double[] countAB = count(data);
         int[] percentageB = percentage(countAB);
         //System.out.println(Arrays.toString(percentageB));
         String[] result = personalityType(percentageB);
         //System.out.println(Arrays.toString(result));
         print(name, percentageB, result, output);
      }
   }
   
   // introduce the program to user
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // count how many A's and B's are in the line of provided data and store them in an array as double
   // in the countAB array, first 4 digits are for A with four dimensions,
   // last 4 digits are for B with four dimensions, if there is any dashes, store it separately in another array
   // return the array for counted A and B
   public static double[] count(String data) {
      double[] countAB = new double[DIMENSIONS*2];
      int[] dashes = new int[1];
      for (int j = 0; j < 7; j++) {
         for (int i = j; i < data.length(); i += 7) {
            char next = data.charAt(i);
            if (next == 'A' || next == 'a') {
               countAB[(j + 1) / 2]++;
            } else if (next == 'B' || next == 'b') {
               countAB[((j + 1) / 2) + 4]++;
            } else {
               dashes[0]++;
            }
         }
      }
      return countAB;
   }
   
   // using provided countAB array, calculate the percentage of B and round to the nearest integer
   // return the percentage of B
   public static int[] percentage(double[] countAB) {
      int[] percentage = new int[DIMENSIONS];
      for (int i = 0; i < DIMENSIONS; i++) {
         percentage[i] = (int) Math.round ((countAB[i+4] * 100) / (countAB[i] + countAB[i+4]));
      }
      return percentage;
   }
   
   // determine the personality type using provided percentage of B
   // if percentage of A and B are same, put "X" for one of the letter of type
   // return 4 combination of letters as an array called result
   public static String[] personalityType(int[] percentageB) {
      String[] left = {"E", "S", "T", "J"};
      String[] right = {"I", "N", "F", "P"};
      String[] result = new String[DIMENSIONS];
      for (int i = 0; i < percentageB.length; i++) {
         if (percentageB[i] < 50) {
            result[i] = left[i];
         } else if ((percentageB[i] > 50)) {
            result[i] = right[i];
         } else {
            result[i] = "X";
         }
      }
      return result;
   }
   
   // using provided name, percentage of B, result of personality type, and PrintStream output
   // make a new output file printing all the information for each person 
   public static void print(String name, int[] percentageB,
                           String[] result, PrintStream output) {
      output.print(name + ": " + Arrays.toString(percentageB) + " = ");
      for (int i = 0; i < result.length; i++) {
         output.print(result[i]);
      }
      output.println();
   }
}       

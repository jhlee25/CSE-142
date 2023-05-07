// Junhyoung Lee
// 4/29/20
// CSE 142
// TA: Aerin Malana
// Assignment #4
// Using 1 Late Day
//
// This program will compare two allplicants to determine which one is stronger apllicant
// using SAT or ACT scores plus a weighted GPA

import java.util.*;

public class Admit {
   public static void main(String[] artg) {
      intro();
      Scanner console = new Scanner(System.in);
      double overallScore1 = getinformation1(console);
      double overallScore2 = getinformation2(console);
      reportResult(overallScore1, overallScore2);
   }
   
   // intro message of the program
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   // use the provided console Scanner to prompt which type of exam applicant #1 have
   // returning sum of exam socre and GPA for applicant #1
   public static double getinformation1(Scanner console) {
      System.out.println("Information for applicant #1:");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int type = console.nextInt();
      if (type == 1) {
         double exam = scoresForSAT(console);
         return totalScores(console, exam);
      } else {
         double exam = scoresForACT(console);
         return totalScores(console, exam);
      }
   }
   
   // use the provided console Scanner to prompt which type of exam applicant #2 have
   // returning sum of exam socre and GPA for applicant #2
   public static double getinformation2(Scanner console) {
      System.out.println("Information for applicant #2:");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int type = console.nextInt();
      if (type == 1) {
         double exam = scoresForSAT(console);
         return totalScores(console, exam); 
      } else {
         double exam = scoresForACT(console);
         return totalScores(console, exam);
      }
   }
   
   // report the calculated score for exam and GPA
   // returning the the overall score of sum of exam and GPA
   public static double totalScores(Scanner console, double exam) {
      System.out.println("    exam score = " + round1(exam));
      double gpa = scoreForGPA(console);
      System.out.println("    GPA score = " + round1(gpa));
      System.out.println();
      return exam + gpa;
   }
   
   // use the provided console Scanner to prompt for sub exams to calculate SAT score
   // returning the SAT score
   public static double scoresForSAT(Scanner console) {
      System.out.print("    SAT math? ");
      int math = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      return ((2 * math) + reading + writing) / 32.0;
   }
   
   // use the provided console Scanner to prompt for sub exams to calculate ACT score
   // returning the ACT score
   public static double scoresForACT(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int math = console.nextInt();
      System.out.print("    ACT reading? ");
      int reading = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      return (english + (2 * math) + reading + science) / 1.8;
   }
   
   // use the provided console Scanner to prompt inforamtion for GPA
   // returning the weighted GPA score
   public static double scoreForGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double overall = console.nextDouble();
      System.out.print("    max GPA? ");
      double max = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      return (overall / max) * 100 *  multiplier;
   }
   
   // report the overall socre and comparison for each applicant
   public static void reportResult(double overallScore1, double overallScore2) {
      System.out.println("First applicant overall score  = " + round1(overallScore1));
      System.out.println("Second applicant overall score = " + round1(overallScore2));
      reportComparison(overallScore1, overallScore2);
   }
   
   // report the comparison for the given overall score of each applicant
   public static void reportComparison(double overallScore1, double overallScore2) {
      if (overallScore1 > overallScore2) {
         System.out.println("The first applicant seems to be better");
      } else if (overallScore1 < overallScore2) {
         System.out.println("The second applicant seems to be better");
      } else {
         System.out.println("The two applicants seem to be equal");
      }
   }
   
   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}
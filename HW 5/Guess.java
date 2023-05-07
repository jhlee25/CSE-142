// Junhyoung Lee
// 5/3/20
// CSE 142
// TA: Aerin Malana
// Assignment #5
//
// This program will produce a guessing game for users. The program will think up an integer randomly
// and tell the user whether the right answer is higher or lower until they get it right
import java.util.*;

public class Guess {
   public static final int MAX = 100;
   
   public static void main(String[] args) {
      intro();
      Scanner console = new Scanner(System.in);
      Random r = new Random();
      int numGuess1 = playGame(console, r);      //number of guesses for first run
      int bestGame = numGuess1;
      int totalGuesses = numGuess1;
      String response =  console.next();
      int totalGames = 1;
      while (response.startsWith("y") || response.startsWith("Y")) {
         int numGuessFrom2 = playGame(console, r);
         if (numGuessFrom2 <= numGuess1) {
            bestGame = numGuessFrom2;
         }
         totalGuesses = totalGuesses + numGuessFrom2;
         response =  console.next();
         totalGames++;
      }
      reportResult(totalGames, totalGuesses, bestGame);
   }
   
   // intro message of the guessing game
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(MAX + " and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }
   
   // use the provided console Scanner to prompt what user's guess is 
   // using the provided Random r to let the program will think up an answer
   // also program will tell user whether the right answer is higher or lower than their guess
   // as well as number of guesses when they get it right
   public static int playGame(Scanner console, Random r) {
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      int answer = 42; //r.nextInt(MAX) + 1;
      int guess = -1;
      int numGuess = 0;
      while (guess != answer) {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numGuess++;
         if (guess > answer) {
            System.out.println("It's lower.");
         } else if (guess < answer) {
            System.out.println("It's higher.");
         } else {
            if (numGuess == 1) {
               System.out.println("You got it right in 1 guess");
            } else {
               System.out.println("You got it right in " + numGuess + " guesses");
            }
         }
      }
      System.out.print("Do you want to play again? ");
      return numGuess;
   }
   
   // use the provided number of total games, total guesses, 
   // and the fewest number of guesses used in any single game
   // to show total games, total guesses, average number of guesses per game, and best game
   public static void reportResult(int totalGames, int totalGuesses, int bestGame) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("    total games   = " + totalGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round1((double)totalGuesses / totalGames));
      System.out.println("    best game     = " + bestGame);
   }
   
   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}
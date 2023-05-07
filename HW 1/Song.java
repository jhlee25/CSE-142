// Junhyoung Lee
// 4/8/20
// CSE 142
// TA: Aerin Malana
// Assignment #1
//
// This program will produce a cumulative song as an output

public class Song {
   public static void main(String[] args) {
      firstVerse();
      System.out.println();
      secondVerse();
      System.out.println();
      thirdVerse();
      System.out.println();
      fourthVerse();
      System.out.println();
      fifthVerse();
      System.out.println();
      sixthVerse();
      System.out.println();
      seventhVerse();
   }
   
   //This is the first verse
   public static void firstVerse() {
      System.out.println("There was an old woman who swallowed a fly.");
      ending1();
      ending2();
   }
   
   //This is the second verse
   public static void secondVerse() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spiderToFly();
      ending1();
      ending2();
   }
   
   //This is the third verse
   public static void thirdVerse() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      birdToSpider();
      spiderToFly();
      ending1();
      ending2();
   }
   
   //This is the fourth verse
   public static void fourthVerse() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catToBird();
      birdToSpider();
      spiderToFly();
      ending1();
      ending2();
   }
   
   //This is the fifth verse
   public static void fifthVerse() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dogToCat();
      catToBird();
      birdToSpider();
      spiderToFly();
      ending1();
      ending2();
   }
   
   //This is the sixth verse
   public static void sixthVerse() {
      System.out.println("There was an old woman who swallowed a deer,");
      System.out.println("Oh deer, that poor deer has family.");
      System.out.println("She swallowed the deer to catch the dog,");
      dogToCat();
      catToBird();
      birdToSpider();
      spiderToFly();
      ending1();
      ending2();
   }
   
   //This is the seventh verse
   public static void seventhVerse() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   //This is second to last line of every verse
   public static void ending1() {
      System.out.println("I don't know why she swallowed that fly,");
   }
   
   //This is the last line of every verse
   public static void ending2() {
      System.out.println("Perhaps she'll die.");
   }
   
   //This is repeated line of swallowing spider to catch the fly
   public static void spiderToFly() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   //This is repeated line of swallowing bird to catch the spider
   public static void birdToSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   //This is repeated line of swallowing cat to catch the bird
   public static void catToBird() {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   
   //This is repeated line of swallowing dog to catch the cat
   public static void dogToCat() {
      System.out.println("She swallowed the dog to catch the cat,");
   }
}
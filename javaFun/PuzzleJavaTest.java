import java.util.Arrays;
public class PuzzleJavaTest {
  public static void main(String[] args) {
    int[] myIntArray = {3,5,1,2,7,9,8,13,25,32};
    String[] myNameArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};

    PuzzleJava puzzles = new PuzzleJava();

    System.out.println("Doint int[] stuff now...");
    System.out.println(puzzles.intStuff(myIntArray));
    System.out.println("Doint String[] stuff now...");
    System.out.println(puzzles.stringStuff(myNameArray));
    puzzles.charStuff();
    System.out.println("Generating int[] with 10 vals from 55-100...");
    System.out.println(Arrays.toString(puzzles.randomInts()));
    System.out.println("Sorting a random int[], displaying its sorted vals and its min and max...");
    puzzles.intSort();
    System.out.println("Here's a String of five random characters...");
    System.out.println(puzzles.fiveChars());
    System.out.println("And here's a String[] of ten such Strings...");
    System.out.println(Arrays.toString(puzzles.tenRandomStrings()));
  }
}
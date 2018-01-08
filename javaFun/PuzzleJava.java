import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class PuzzleJava {

  //Shuffle a String[]
  public String[] shuffleStrings (String[] arr) {
    int index;
    String temp;
    Random random = new Random();
    for (int i = arr.length - 1; i > 0; i -= 1) {
      index = random.nextInt(i + 1);
      temp = arr[index];
      arr[index] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }

  //Shuffle an int[]
  public int[] suffleInts (int[] arr) {
    int index, temp;
    Random random = new Random();
    for (int i = arr.length -1; i > 0; i -= 1) {
      index = random.nextInt(i + 1);
      temp = arr[index];
      arr[index] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }  

  //Generate array of chars a-z
  public char[] letterArray() {
    char[] alphabetically;
    alphabetically = new char[26];
    for (int i = 0; i < 26; i += 1) {
      char letter = (char) (i + 97);
      alphabetically[i] = letter;
    }
    return alphabetically;
  }

  //Create a pseudorandomly shuffled alphabet char[] using letterArray()
  public char[] shuffleAlphabet() {
    char[] letters = letterArray();
    int index;
    char temp;
    Random random = new Random();
    for (int i = letters.length -1; i > 0; i -= 1) {
      index = random.nextInt(i + 1);
      temp = letters[index];
      letters[index] = letters[i];
      letters[i] = temp;
    }
    return letters;
  }

  //Create a char[] with shuffleAlphabet(), print the first and last chars, and display message if first is a vowel
  public void charStuff() {
    char[] letters = shuffleAlphabet();
    System.out.println("The first letter in the letters array is: " + letters[0]);
    if (letters[0] == 97 || letters[0] == 101 || letters[0] == 105 || letters[0] == 111 || letters[0] == 117 || letters[0] == 121) {
      System.out.println("It's a vowel!");
    }
    if (letters[0] == 121) {
      System.out.println("(Yes, y is a vowel in this context.)");
    }
    System.out.println("The last letter in the letters array is: " + letters[25]);
  }

  //Total the ints in an int[], return an ArrayList<Integer> of all those > 10
  public ArrayList<Integer> intStuff(int[] arr) {
    int sum = 0;
    ArrayList<Integer> gTTen = new ArrayList<Integer>();
    for (int value : arr) {
      sum += value;
      if (value > 10) {
        gTTen.add(value);
      }
    }
    System.out.println(sum);
    return gTTen;
  }

  //Shuffle the strings in a String[], print them out, and return a new ArrayList<String> of those longer than 5
  public ArrayList<String> stringStuff(String[] arr) {
    shuffleStrings(arr);
    ArrayList<String> gTFive = new ArrayList<String>();
    for (String name : arr) {
      System.out.println(name);
      if (name.length() > 5) {
        gTFive.add(name);
      }
    }
    return gTFive;
  }

  //Generate an int[] of 10 random ints from 55–100
  public int[] randomInts() {
    int[] intArray;
    intArray = new int[10];
    Random rand = new Random();
    for (int i = 0; i < 10; i += 1) {
      intArray[i] = rand.nextInt(46) + 55;
    }
    return intArray;
  }

  //Sort a random int[] from randomInts(), then display it along with its min and max values
  public void intSort() {
    int[] randos = randomInts();
    Arrays.sort(randos);
    System.out.println(Arrays.toString(randos));
    System.out.format("Min: %d", randos[0]);
    System.out.println();
    System.out.format("Max: %d", randos[randos.length -1]);
    System.out.println();
  }

  //Create a random string of five characters
  public String fiveChars() {
    StringBuilder strBuilder = new StringBuilder();
    Random rand = new Random();
    for (int i = 0; i < 5; i += 1) {
      char newChar = (char) (rand.nextInt(27) + 97);
      strBuilder.append(newChar);
    }
    return strBuilder.toString();
  }

  //Create a String[] of ten Strings, five random chars each
  public String[] tenRandomStrings() {
    String[] myStrings;
    myStrings = new String[10];
    for (int i = 0; i < 10; i += 1) {
      myStrings[i] = fiveChars();
    }
    return myStrings;
  }
}
import java.util.Arrays;
public class BasicJavaTest {
  public static void main(String[] args) {
    BasicJava basic = new BasicJava();
    int[] myArray = {1,3,5,17,9,13};
    int[] myArrayNeg = {1,-3,5,-17,9,13};

    basic.to255();
    basic.oddTo255();
    basic.printSum();

    System.out.println("Printing all the values in the array...");
    basic.printFromArray(myArray);

    System.out.println("Printing the max value in the array...");
    basic.printMax(myArray);

    System.out.println("Printing the average of the array...");
    basic.getAverage(myArray);

    System.out.println("Generating array of odd numbers to 255...");
    basic.oddArray();

    System.out.println("Getting the number of values in the array greater than 10...");
    System.out.println(basic.greaterThanY(myArray, 10));

    System.out.println("Removing negative numbers from array [1,-3,5,-17,9,13]...");
    int[] eliminated = basic.eliminateNegs(myArrayNeg);
    System.out.println(Arrays.toString(eliminated));

    System.out.println("Producing an array with the max, min, and average of an array...");
    int[] results = basic.maxMinAve(myArray);
    System.out.println(Arrays.toString(results));

    System.out.println("Shifting values in an array one to the left, putting zero at the end...");
    int[] shifted = basic.arrayShift(myArray);
    System.out.println(Arrays.toString(shifted));

    System.out.println("And again...");
    int[] shiftedTwice = basic.arrayShift(shifted);
    System.out.println(Arrays.toString(shiftedTwice));
  }
}
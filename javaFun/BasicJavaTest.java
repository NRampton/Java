public class BasicJavaTest {
  public static void main(String[] args) {
    BasicJava basic = new BasicJava();
    basic.to255();
    basic.oddTo255();
    basic.printSum();
    int[] myArray = {1,3,5,17,9,13};
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
    
  }
}
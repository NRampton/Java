import java.util.ArrayList;
import java.lang.Integer;
public class BasicJava {
  public void to255() {
    System.out.println("Printing from 1 to 255...");
    for (int i = 1; i <= 255; i += 1) {
      System.out.println(i);
    }
  }

  public void oddTo255() {
    System.out.println("Printing odd integers from 1 to 255...");
    for (int i = 1; i <= 255; i += 2) {
      System.out.println(i);
    }
  }

  public void printSum() {
    int sum = 0;
    String output;
    for (int i = 0; i <= 255; i += 1) {
      sum = sum += i;
      output = String.format("New number: %d Sum: %d", i, sum);
      System.out.println(output);
    }
  }

  public void printFromArray(int[] arr) {
    for (int value : arr) {
      System.out.println(value);
    }
  }

  public void printMax(int[] arr) {
    int max = arr[0];
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
    }
    System.out.println(max);
  }

  public void getAverage(int[] arr) {
    int sum = 0;
    for (int value : arr) {
      sum += value;
    }
    System.out.println(sum / arr.length);
  }

  public void oddArray() {
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i = 1; i <= 255; i += 2) {
      y.add(i);
    }
    System.out.println(y);
  }

  public int greaterThanY(int[] arr, int y) {
    int total = 0;
    for (int value : arr) {
      if (value > y) {
        total += 1;
      }
    }
    return total;
  }

  public int[] eliminateNegs(int[] arr) {
    for (int i = 0; i < arr.length; i += 1) {
      if (arr[i] < 0) {
        arr[i] = 0;
      }
    }
    return arr;
  }

  public int[] maxMinAve(int[] arr) {
    int[] results = new int[3];
    int max = arr[0];
    int min = arr[0];
    int sum = 0;
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
      if (value < min) {
        min = value;
      }
      sum += value;
    }
    results[0] = max;
    results[1] = min;
    results[2] = (sum/arr.length);
    return results;
  }

  public int[] arrayShift(int[] arr) {
    for (int i = 0; i < arr.length -1; i += 1) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length-1] = 0;
    return arr;
  }
}
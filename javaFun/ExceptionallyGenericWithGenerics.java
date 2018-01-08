import java.util.ArrayList;

public class ExceptionallyGenericWithGenerics {
  public static void main(String[] args) {
    ArrayList<Integer> myList = new ArrayList<Integer>();
    myList.add("A string");
    myList.add(14);
    myList.add("Another string");
    myList.add(756);
    for (int i = 0; i < myList.size(); i += 1) {
        Integer castedValue = (Integer) myList.get(i);
        System.out.println(castedValue);
    }
  }
}
import java.util.ArrayList;

public class ExceptionallyGeneric {
  public static void main(String[] args) {
    ArrayList<Object> myList = new ArrayList<Object>();
    myList.add("A string");
    myList.add(14);
    myList.add("Another string");
    myList.add(756);
    for (int i = 0; i < myList.size(); i += 1) {
      try {
        Integer castedValue = (Integer) myList.get(i);
        System.out.println(castedValue);
      } catch (ClassCastException err) {
        System.out.format("ERROR ON INDEX %d", i);
        System.out.println(err.toString());
        System.out.println();
      }
    }
  }
}
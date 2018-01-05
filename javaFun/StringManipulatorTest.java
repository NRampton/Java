public class StringManipulatorTest {
  public static void main(String[] args) {
    StringManipulator manipulator = new StringManipulator();
    String str1 = "   Hey there.  ";
    String str2 = "  Hi, how are you?  ";
    String trimmed = manipulator.trimAndConcat(str1, str2);
    System.out.println("Trimming and concatenating...");
    System.out.println(trimmed);
    Integer indexOf = manipulator.getIndexOrNull(str1, 'H');
    System.out.println("Finding the index of H...");
    System.out.println(indexOf);
    Integer indexOf2 = manipulator.getIndexOrNull(str1, "I'm not sure it's in there...");
    System.out.println("Finding the index of a substring...");
    System.out.println(indexOf2);
    String concatSub = manipulator.concatSubString(str1, 3, 5, str2);
    System.out.println(concatSub);
  }
}
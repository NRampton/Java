public class SinglyLinkedListTest {
  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();
    sll.printValues();
    sll.add(5);
    sll.printValues();
    sll.add(4);
    sll.printValues();
    sll.remove();
    sll.printValues();
    sll.add(4);
    sll.add(3);
    sll.add(2);
    sll.add(1);
    sll.printValues();
    sll.find(3);
    sll.remove(4);
    sll.printValues();
  }
}
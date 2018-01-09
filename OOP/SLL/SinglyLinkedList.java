public class SinglyLinkedList {
  Node head;

  //constructor
  public SinglyLinkedList() {
    this.head = null;
  }

  //instance methods
  public void add(int val) {
    Node newNode = new Node(val);
    if (this.head == null) {
      this.head = newNode;
      return;
    }
    Node current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }
  public void remove() {
    if (this.head == null) {
      return;
    }
    Node current = this.head;
    while (current.next.next != null) {
      current = current.next;
    }
    current.next = null;
  }
  //print all values in the list in order
  public void printValues() {
    if (this.head == null) {
      System.out.println("No values in the list!");
      return;
    }
    Node current = this.head;
    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }
    System.out.println("That's all, folks!");
  }
  //return the first node with a given value
  public Node find(int val) {
    if (this.head == null) {
      System.out.println("Not found");
      Node emptyNode = new Node(0);
      return emptyNode;
    }
    int counter = 0;
    Node current = this.head;
    while (current != null) {
      if (current.value == val) {
        System.out.println("Found it! It was zero-indexed node number " + counter);
        return current;
      }
      current = current.next;
      counter += 1;
    }
    System.out.println("Not found");
    Node emptyNode = new Node(0);
    return emptyNode;
  }
  //remove a node from the SLL at index num
  public void remove(int num) {
    if (this.head == null) {
      System.out.println("List contains no values.");
      return;
    }
    if (num == 0) {
      this.head = this.head.next;
      return;
    }
    Node current = this.head;
    for (int i = 0; i < num - 1; i += 1) {
      if (current.next == null) {
        System.out.println("There aren't that many nodes in the list.");
        return;
      }
      current = current.next;
    }
    current.next = current.next.next;
    return;
  }
}
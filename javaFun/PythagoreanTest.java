public class PythagoreanTest {
  public static void main(String[] args) {
    Pythagorean hypotenuse = new Pythagorean();
    double calculatedHypotenuse = hypotenuse.calculateHypotenuse(3, 4);
    System.out.println("The hypotenuse of a triangle with legs 3 and 4 is " + calculatedHypotenuse);
  }
}
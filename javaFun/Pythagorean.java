import java.lang.Math;
public class Pythagorean {
  public double calculateHypotenuse(int legA, int legB) {
    double dubLegA = legA;
    double dubLegB = legB;
    return Math.sqrt(Math.pow(dubLegA, 2.0) + Math.pow(dubLegB, 2.0));
  }
}
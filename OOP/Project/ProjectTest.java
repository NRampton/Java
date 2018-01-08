public class ProjectTest {
  public static void main(String[] args) {
    Project firstProj = new Project("First", "Do a first thing");
    System.out.println(firstProj.elevatorPitch());
    Project secondProj = new Project("Second");
    System.out.println(secondProj.elevatorPitch());
    secondProj.setDescription("Do a second thing");
    System.out.println(secondProj.getName());
    secondProj.setInitialCost(30.0);
    System.out.println(secondProj.elevatorPitch());
  }
}
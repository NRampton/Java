import java.util.ArrayList;

public class Portfolio {
  private ArrayList<Project> projects = new ArrayList<>();

  //getters and setters
  //add a project to a portfolio
  public void addProject(Project proj) {
    this.projects.add(proj);
  }
  //get all projects in a portfolio
  public ArrayList<Project> getProjects() {
    return this.projects;
  }

  //instance methods
  //add up and return the total cost of a portfolio
  public double getPortfolioCost() {
    double sum = 0;
    for (Project proj : this.projects) {
      sum += proj.getInitialCost();
    }
    System.out.println("This portfolio costs:");
    return sum;
  }
  //display elevator pitches for all projects in a folder
  public void showPortfolio() {
    System.out.println("Here are the pitches for the projects in this portfolio:");
    for (Project proj : this.projects) {
      System.out.println(proj.elevatorPitch());
    }
  }
}
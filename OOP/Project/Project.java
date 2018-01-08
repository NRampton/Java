public class Project {
  private String name;
  private String description;
  private double initialCost;


  //Overloaded constructors for various numbers of provided arguments
  public Project() {    
  }
  public Project(String name) {
    this.name = name;
  }
  public Project(String name, String description) {
    this.name = name;
    this.description = description;
  }
  public Project(String name, String description, double initialCost) {
    this.name = name;
    this.description = description;
    this.initialCost = initialCost;
  }


  //Getters and Setters
  //name getter
  public String getName() {
    return this.name;
  }
  //name setter
  public void setName(String name) {
    this.name = name;
  }
  //description getter
  public String getDescription() {
    return this.description;
  }
  //description setter
  public void setDescription(String description) {
    this.description = description;
  }
  //initialCost getter
  public double getInitialCost() {
    return this.initialCost;
  }
  //initialCost setter
  public void setInitialCost(double cost) {
    this.initialCost = cost;
  }

  
  //instance methods
  public String elevatorPitch() {
    return this.name + " ($" + this.initialCost + "): " + this.description;
  }
}
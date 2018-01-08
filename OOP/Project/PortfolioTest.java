public class PortfolioTest {
  public static void main(String[] args) {
    Portfolio myPort = new Portfolio();
    Project firstProj = new Project("first", "Do some first stuff", 300);
    Project secondProj = new Project("second", "Do some second stuff", 500);
    myPort.addProject(firstProj);
    myPort.addProject(secondProj);
    System.out.println(myPort.getPortfolioCost());
    myPort.showPortfolio();
  }
}
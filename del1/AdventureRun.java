package del1;

public class AdventureRun {
  GameEngine gameEngine = new GameEngine();

  public static void main(String[] args) {
    new AdventureRun().go();
  }
  void go (){
    gameEngine.startGame();
  }
}

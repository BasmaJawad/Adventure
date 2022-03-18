package del1;

public class GameEngine {
    private boolean playAgain;
    private final TheGame theGame = new TheGame();


    void startGame() {
        do {
            theGame.createGame();
            theGame.userAction();
            changePlayAgain();
        } while (playAgain);
    }


    void changePlayAgain() {
        theGame.getUserInterface().playAgain();
        String input = theGame.getUserInterface().returnsUserInput();
        switch(input.toLowerCase()) {
            case "yes", "y":
                playAgain = true;
                break;
            case "no", "n":
                playAgain = false;
                break;
            default:
                changePlayAgain();
        }
        System.out.println();
    }

}

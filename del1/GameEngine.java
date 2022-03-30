package del1;

public class GameEngine { // kontrollerer det store game loop
    private final TheGame theGame = new TheGame();
    private boolean playAgain;


    void startGame() { // Metode der starter og kører spillet
        do {
            theGame.createGame();
            theGame.userAction();
            changePlayAgain(); // kontrollerer om brugeren vil spille igen
        } while (playAgain);
    }

    void changePlayAgain() {
        theGame.getUserInterface().playAgain();
        String input = theGame.getUserInterface().returnsUserInput();

        switch(input.toLowerCase()) {
            case "yes", "y":
                playAgain = true;
                theGame.clearItemInventoriesForNewGame(); //resetter inventories
                break;
            case "no", "n":
                playAgain = false;
                break;
            default:
                changePlayAgain(); // Kalder metoden sig indtil 'input' er genkendeligt
        }
        System.out.println();
    }

}
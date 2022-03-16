package del1;

import java.util.Scanner;

public class GameEngine {
    private boolean playAgain;
    private TheGame gameControl = new TheGame();
    private Map map = new Map();


    void startGame() {
        do {
            createGame();
            gameControl.userAction();
            changePlayAgain();
        } while (playAgain);
    }

    void createGame(){
        gameControl.setPlayerWon(false);
        map.createRooms();
        gameControl.setWinnerRoom(map.getRoom5());
        gameControl.setCurrentRoom(map.getRoom1());
        gameControl.getUserInterface().printIntroduction(gameControl.getCurrentRoom());
    }

    void changePlayAgain() {
        Scanner in = new Scanner(System.in);
        String input;
        gameControl.getUserInterface().playAgain();
        input = in.nextLine();
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

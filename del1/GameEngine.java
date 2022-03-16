package del1;

import java.util.Scanner;

public class GameEngine {
    private boolean playAgain;
    private TheGame theGame = new TheGame();
    private Map map = new Map();


    void startGame() {
        do {
            createGame();
            theGame.userAction();
            changePlayAgain();
        } while (playAgain);
    }

    void createGame(){
        theGame.setPlayerWon(false);
        map.createRooms();
        theGame.setWinnerRoom(map.getRoom5());
        theGame.setCurrentRoom(map.getRoom1());
        theGame.getUserInterface().printIntroduction(theGame.getCurrentRoom());
    }

    void changePlayAgain() {
        Scanner in = new Scanner(System.in);
        String input;
        theGame.getUserInterface().playAgain();
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

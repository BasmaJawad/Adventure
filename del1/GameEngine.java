package del1;

public class GameEngine { // Denne class kontrollerer det overalle game loop og hvad spil der skal spilles
    private final TheGame theGame = new TheGame(); // Et spil objekt, 'TheGame', kaldt "theGame": Adventure
    private boolean playAgain; // En boolean der sættes efter om brugeren vil spille igen, yes; true no ; false


    void startGame() { // Metode der starter og kører spillet, 'theGame'
        do { // og fortsætter med at:
            theGame.createGame(); // Kalde metode i 'theGame', der skaber et spil
            theGame.userAction(); // Kalde metode i 'theGame', der ud efter brugerinput
            changePlayAgain(); // Metodekald der ud efter brugerinput sætter 'playAgain'.
        } while (playAgain); // Indtil at 'playAgain' er falsk, brugeren ville ikke spille igen
    }

    void changePlayAgain() { // Ud efter brugerinput sættes 'playAgain' til enten true or false
        theGame.getUserInterface().playAgain(); //Metoder i "UserInterface" der spørg om spillet skal fortsætte
        String input = theGame.getUserInterface().returnsUserInput(); //og tager brugerinput og gemmer det i variablen 'input'
        switch(input.toLowerCase()) { // Ud efter String variablen 'input', i lower case, er sat til at være:
            case "yes", "y": // Hvis brugeren svarede ja til spørgsmålet
                playAgain = true; // Så er "GameEngine" variablen 'playAgain' sat til at være sand
                theGame.clearItemInventoriesForNewGame();
                break; // og spillet fortsætter
            case "no", "n": // Hvis brugerens svar er nej,
                playAgain = false; // så er variablen sat til at være falsk
                break; // og spillet/programmet slutter
            default: // Hvis 'input', det som brugeren skrev, ikke er genkendeligt i nogen CASE så;
                changePlayAgain(); // Kalder metoden sig indtil 'input' er genkendeligt
        }
        System.out.println(); // Printer en tom linje
    }

}
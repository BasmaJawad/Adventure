package del1;

import java.util.Random;

public class Door {
  private String doorName; // En dør har et navn der gerne skulle kunne indikere hvilken nøgle passer
  private KeyLockPair lock; // En dør har en lås, der er en Enum, KeyLockPair, som den deler med en nøgle, key
  private boolean isClosed = true; // En dør er altid lukket når den bliver skabt


  public Door() { // En dør uden nogen argumenter er sat til at:
   doorName = "wooden door"; // blive kaldt en træ dør
   lock = KeyLockPair.NONE; // og at dens lås ikke har nogen nøgle kombination
  }

  public Door(String doorName) { // En dør med et String argument vil blive sat til at:
    this.doorName = doorName; // blive kaldt det som skrevet ind som et argument
    randomiseKeyLockPair(); // og at dens lås er en tilfældig nøgle kombination
  }

  public Door(String doorName, String color) { // En dør med to String argumenter vil blive sat til at:
    this.doorName = doorName; // være kaldt det som blev skrevet ind i det første argument
    setLock(color); // og at dens lås vil være sat til at være en nøgle kombination ud efter den andet String argument
  }

  public void openDoor(KeyLockPair key) { // For at åbne en dør, giv den nøglens attribut KeyLockPair key
      if (lock == KeyLockPair.NONE) { // Hvis dørens lås ingen nøgle kombination
        isClosed = false; // så er døren ikke lukket
        // Printer ud at brugeren har åbnet den ulåste dør; "doorName" måske også retning og rum navn nævnes
      } else { // Må der være en nøgle kombination til dørens lås
        if (lock == key) { // Hvis dørens lås og den givne nøgles KeyLockPair er en kombination
          isClosed = false; // så er døren blivet åbnet og er derfor ikke lukket
          // Printer ud at brugeren har åbnet for den låste dør "doorName" med nøgle "keyName"
        }
      } // Døren er nu enten åbnet fordi den ingen lås havde eller den blev givet den rigtige nøgle
      if (isClosed) { // Men hvis døren stadig er lukket
        // Printer ud at brugeren forsøgte at åbne den låste dør "dorName"
      }
  }

  public void randomiseKeyLockPair() { // gør en dørs nøgle lås kombination tilfældig
    Random random = new Random();
    int num = random.nextInt(3) + 1; // har en tal variabel mellem 1 og 3
    switch (num) { // Hvis det er det tal er så blive låsen sat at være:
      case 1:
        lock = KeyLockPair.YELLOW; // GUL
        break;
      case 2:
        lock = KeyLockPair.BLUE; // BLÅ
        break;
      case 3:
        lock = KeyLockPair.RED; // RØD
        break;
      default:
        lock = KeyLockPair.NONE; // INGEN (som i der ikke er en nøgle kombination til låsen eller at der en lås på døren)
    }
  }

  // Getters and Setters
  public void setLock (KeyLockPair keyLockPair) {
    lock = keyLockPair;
  }
  public void setLock(String color) { // Overload metode der sætter ud efter en String dørens lås kombinationen:
    color = color.toLowerCase(); // String argumentet sættes i lower case og gemmes i den samme variabel
    if (color.contains("ye")) { // hvis det indeholder denne tekst "ye" noget som helst sted;
      setLock(KeyLockPair.YELLOW); // så er låsen sat til at være KeyLockPair.YELLOW, altså gul
    } else if (color.contains("bl")) { // også videre...
      setLock(KeyLockPair.BLUE);
    } else if (color.contains("re")) {
      setLock(KeyLockPair.RED);
    } else if (color.contains("no")) {
      setLock(KeyLockPair.NONE);
    } else { // ellers er der ikke skrevet en godkendt farve ind og:
      randomiseKeyLockPair(); // låsens nøgle lås kombination vil blive helt tilfældig
    }
  }
}

package del1;

public class Key extends Item{ // En nøgle er en Item som kan holdes og bruges spilleren eller en NPC
  private KeyLockPair key; // En nøgle har en altid lås kombination

  public Key(String keyShortName, String keyLongName) { // En nøgle har et kort og et langt navn
    super(keyShortName, keyLongName); // dette gives videre til overklassen Item og kan hentes og settes der
    key = getKey(keyShortName); // nøgle lås kombinationen bliver sat til at være noget ud efter nøglens korte navn
  }

  // Getters og Setters
  public void setKey(KeyLockPair keyColor) {
    key = keyColor;
  }
  public KeyLockPair getKey() {
    return key;
  }
  public KeyLockPair getKey(String keyColor) { // Overloaded metode der tager et String argument, det indikere en farve
    keyColor = keyColor.toLowerCase(); // String argumentet bliver sat til at være i lower case og gemmes i sig selv
    if (keyColor.contains("ye")) { // Hvis dette String Argument indeholder "ye" så vil:
      setKey(KeyLockPair.YELLOW); // nøglens lås kombination blive sat til at være KeyLockPair.YELLOW, altså gul
    } else if (keyColor.contains("bl")) { // og hvis det indeholder "bl"
      setKey(KeyLockPair.BLUE); // så er kombinationen blå
    } else if (keyColor.contains("re")) { // også videre
      setKey(KeyLockPair.RED);
    } else { // Men hvis der ikke er nogen af de passene fraser i String argumentet, så vil:
      setKey(KeyLockPair.NONE); // nøgle lås kombinationen være sat til at ingen og dermed er nøglen ugyldig
    }
    return key; // Til sidst aflevere vi den ændrede nøgle tilbage
  }

}

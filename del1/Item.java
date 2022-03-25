package del1;

public class Item {
    private String itemNameShort;
    private String itemNameLong;
    private ItemType itemType;


    Item(String itemNameShort, String itemNameLong) {
        this.itemNameShort = itemNameShort;
        this.itemNameLong = itemNameLong;
        setItemType(itemNameShort);
    }

    Item(String itemNameShort, String itemNameLong, String itemType) {
        this.itemNameShort = itemNameShort;
        this.itemNameLong = itemNameLong;
        setItemType(itemType);
    }

    private void setItemType(String itemType) { // Metode der tager et String argument, det indikere en type item
        itemType = itemType.toLowerCase(); // String argumentet bliver sat til at være i lower case og gemmes i sig selv
        if (itemType.contains("ye")) { // Hvis dette String Argument indeholder "ye" så vil:
            this.itemType = ItemType.YELLOW; // sat til at være gul
        } else if (itemType.contains("bl")) { // og hvis det indeholder "bl"
            this.itemType = ItemType.BLUE; // så er kombinationen blå
        } else if (itemType.contains("re")) { // også videre
            this.itemType = ItemType.RED;
        } else { // Men hvis der ikke er nogen af de passene fraser i String argumentet, så vil:
            this.itemType = ItemType.NONE; // hvis den er denne item type så er det en speciel winner item
            itemNameShort = "Holy Grail";
            itemNameLong = "The Holy Grail";
        }
    }

    // Getters
    public String getItemNameShort() {
        return itemNameShort;
    }

    public String getItemNameLong() {
        return itemNameLong;
    }

    public ItemType getItemType() {
        return itemType;
    }
}


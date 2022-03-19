package del1;

public class Item {
    private final String itemNameShort;
    private final String itemNameLong;


    Item(String itemNameShort, String itemNameLong) {
        this.itemNameShort = itemNameShort;
        this.itemNameLong = itemNameLong;
    }

    // Getters
    public String getItemNameShort() {
        return itemNameShort;
    }

    public String getItemNameLong() {
        return itemNameLong;
    }
}


package del1;

public class Item {
    private String itemNameShort;
    private String itemNameLong;


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


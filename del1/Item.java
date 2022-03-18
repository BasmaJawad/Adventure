package del1;

import java.util.ArrayList;

public class Item {
    private final String itemNameShort;
    private final String itemNameLong;

    Item(String itemNameShort, String itemNameLong) {
        this.itemNameShort = itemNameShort;
        this.itemNameLong = itemNameLong;
    }

    public String getItemNameShort() {
        return itemNameShort;
    }

    public String getItemNameLong() {
        return itemNameLong;
    }

    }


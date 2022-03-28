package del1;

public class Weapon extends Item {

    private int weaponUses;

    Weapon(String itemNameShort, String itemNameLong) {
        super(itemNameShort, itemNameLong);
    }

    Weapon(String itemNameShort, String itemNameLong, int weaponUses) {
        super(itemNameShort, itemNameLong);
        this.weaponUses = weaponUses;
    }


    int getWeaponUses(){
        return weaponUses;
    }
    void setWeaponUses(int weaponUses){
        this.weaponUses = weaponUses;
    }

}

package del1;

public class RangedWeapon extends Weapon{

    private int weaponUses;

    RangedWeapon(String itemNameShort, String itemNameLong, int weaponUses) {
        super(itemNameShort, itemNameLong, weaponUses);

    }

    void setWeaponUses(int weaponUses){
        this.weaponUses = weaponUses;
    }

    int getWeaponUses(){
        return weaponUses;
    }

}


package del1;

public class RangedWeapon extends Weapon{

    RangedWeapon(String itemNameShort, String itemNameLong, int weaponUses) {
        super(itemNameShort, itemNameLong, weaponUses);
    }

    int getWeaponUses(){
        return super.getWeaponUses();
    }

    void setWeaponUses(int usesLeft ){
        super.setWeaponUses(usesLeft);
    }

}


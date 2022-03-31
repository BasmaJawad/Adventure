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


    public boolean canUse(Weapon equippedWeapon, UserInterface UI){
        if (equippedWeapon instanceof RangedWeapon){
            int remainingUses = equippedWeapon.getWeaponUses();
            if (remainingUses<1)
                return false;
            else{
                 remainingUses--;
                 setWeaponUses(remainingUses);
                UI.usesLeft(weaponUses);
                return true;
            }

        }
        else
            return true;
    }

    // Getters og Setters
    int getWeaponUses(){
        return weaponUses;
    }
    void setWeaponUses(int weaponUses){
        this.weaponUses = weaponUses;
    }
}

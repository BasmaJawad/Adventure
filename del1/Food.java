package del1;

public class Food extends Item {
    private int healthPoint;

    Food(String shortName, String longName, int healthPoint){
        super(shortName, longName);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
}

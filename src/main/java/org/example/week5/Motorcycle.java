package org.example.week5;

public class Motorcycle extends Vehicle{
    public Motorcycle(String modelName){
        super(modelName);
    }

    public Motorcycle(String modelName, int milleage, int health) {
        super(modelName, milleage, health);
    }
    @Override
    public String service(){
        return getModelName() + " " + getMilleage() + " " + getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 50000;
    }

    public void race(int raceMiles){
        setMilleage(getMilleage() + raceMiles);

        int newHealth = getHealth() - raceMiles/10;

        if(newHealth < 40){
            int reduce = calculateRemainingLifespan() - 5000;
        }
    }
}

package org.example.week5;

public class Truck extends Vehicle implements Repairable{
    public Truck(String modelName) {
        super(modelName);
    }
    public Truck(String modelName, int milleage, int health){
        super(modelName, milleage, health);
    }

    @Override
    public String service(){
        return getModelName() + " " + getMilleage() + " " + getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 300000;
    }

    @Override
    public String repair(){
        return "Enging hauled" + getModelName();
    }

    public void haul(int loadWeight){
        int healthReduction = 5;

        if(loadWeight > 5000){
            healthReduction = 15;
        }

        setHealth(getHealth() - healthReduction);

        if(getHealth()<30){
            int reduce = expectedLifespan() - 20000;
        }
    }

}

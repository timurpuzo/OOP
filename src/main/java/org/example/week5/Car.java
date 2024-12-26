package org.example.week5;

public class Car extends Vehicle implements Repairable{
    public Car(String modelName){
        super(modelName);
    }

    public Car(String modelName, int milleage, int health) {
        super(modelName, milleage, health);
    }

    @Override
    public String service(){
        return getModelName()+ " " + getMilleage() + " " + getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 150000;
    }

    @Override
    public String repair(){
        setHealth(100);
        return getModelName();
    }

    public void drive(int miles){
        setMilleage(getMilleage()+miles);
        setHealth(getHealth()-miles/100);

        if(getHealth()<30){
            int reduce = expectedLifespan() - 10000;
        }
    }
}




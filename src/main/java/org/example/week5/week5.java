package org.example.week5;

import java.util.ArrayList;

public class week5 {
    public static void main(String[] args){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("BMW", 20000, 90));
        vehicles.add(new Truck("BigRig", 60000, 75));
        vehicles.add(new Motorcycle("Speedster", 15000, 85));

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.service());
            vehicle.simulateYear();
        }


        }
}

abstract class Vehicle{
    private String modelName;
    private int milleage;
    private int health;

    public Vehicle(String modelName){
        this.modelName = modelName;
        this.milleage = 0;
        this.health = 100;
    }
    public Vehicle(String modelName,int milleage, int health){
        this.modelName = modelName;
        this.milleage = milleage;
        this.health = health;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMilleage() {
        return milleage;
    }

    public void setMilleage(int new_milleage) {
        this.milleage = new_milleage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health>0 && health<100){
            this.health = health;
        }else{
            System.out.println("Mora izmedju 0 i 100 biti ne mere ispod i iznad");
        }
    }
    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance(){
        return health<70;
    }
    public int calculateRemainingLifespan(){
        int lifespan = expectedLifespan() - milleage;
        if(health<50){
            lifespan = (int) (lifespan*(health/100.0));
        }
        return Math.max(lifespan,0);
    }
    @Override
    public String toString(){
        return this.modelName + " " + this.milleage + " " + this.health;
    }

    public void simulateYear(){
        if(milleage > expectedLifespan()/2){
            health = health - 5;
        }
        int remainingLifespan = calculateRemainingLifespan();
    }
}

interface Repairable{
    public String repair();
}


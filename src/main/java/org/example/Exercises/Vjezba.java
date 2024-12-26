package org.example.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Vjezba {
    public static void main(String[] args) {

    }
}

interface Repairable{
    String repair();
}

abstract class Vehicle{
    private String modelName;
    private int milleage;
    private int health;

    public Vehicle(String modelName){
        this(modelName, 0, 100);
    }
    public Vehicle(String modelName, int milleage, int health){
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

    public void setMilleage(int milleage) {
        this.milleage = milleage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance(){
        return health < 70;
    }

    public int calculateRemainingLifespan(){
        int lifespan = expectedLifespan();

        if(health < 50){
            lifespan -= (50-health)/10;
        }
        return (lifespan - health);
    }

    public void simulateYear(){
        milleage++;
        if(milleage > expectedLifespan()/2){
            health -= 5;
        }
    }
}

class Car extends Vehicle implements Repairable{
    public Car(String modelName){
        super(modelName);
    }

    public Car(String modelName, int milleage, int health) {
        super(modelName, milleage, health);
    }

    @Override
    public String repair(){
        return "Engine tuned and oil changed for " + getModelName();
    }

    public String service(){
        return getModelName() + " " + getMilleage() + " " + getHealth();
    }

    public int expectedLifespan() {
        return 150000;
    }

    public int  drive(int miles){
        int lifespan = expectedLifespan();
        setMilleage(getMilleage()-miles);
        if(getHealth() <= 30){
            lifespan -= 10000;
        }
        return lifespan;
    }
}

class Truck extends Vehicle implements Repairable{
    public Truck(String modelName){
        super(modelName);
    }

    public Truck(String modelName, int milleage, int health) {
        super(modelName, milleage, health);
    }

    @Override
    public String repair(){
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    public String service(){
        return getModelName() + " " + getMilleage() + " " + getHealth();
    }

    public int expectedLifespan() {
        return 300000;
    }

    public int  haul(int loadWeight){
        int lifespan = expectedLifespan();

        if(getHealth() <= 40){
            lifespan -= 20000;
        }
        return lifespan;
    }

}

class Motorcycle extends Vehicle{
    public Motorcycle(String modelName){
        super(modelName);
    }

    public Motorcycle(String modelName, int milleage, int health) {
        super(modelName, milleage, health);
    }

    public String service(){
        return getModelName() + " " + getMilleage() + " " + getHealth();
    }

    public int expectedLifespan() {
        return 50000;
    }

    public int race(int raceMiles){
        setMilleage(getMilleage()+raceMiles);
        int lifespan = expectedLifespan();
        if(getHealth()<=40){
            lifespan -= 5000;
        }
        return lifespan;
    }

}




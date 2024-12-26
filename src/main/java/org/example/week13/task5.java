package org.example.week13;

public class task5 {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();

        context.transitionToYellow();
        context.transitionToGreen();
    }
}

class TrafficLightContext{
    private TrafficLightState current;

    public TrafficLightContext(){
        this.current = new RedLightState();
    }

    public void setState(TrafficLightState state){
        this.current = state;
    }

    public void transitionToRed(){
        current.transitionToRed(this);
    }

    public void transitionToYellow(){
        current.transitionToYellow(this);
    }

    public void transitionToGreen(){
        current.transitionToGreen(this);
    }
}

interface TrafficLightState{
    void transitionToRed(TrafficLightContext context);
    void transitionToYellow(TrafficLightContext context);
    void transitionToGreen(TrafficLightContext context);
}

class RedLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Traffic light is already Red.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transitioning from Red to Green.");
        context.setState(new GreenLightState());
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Red to Yellow.");
    }
}

// YellowLightState class
class YellowLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Transitioning from Yellow to Red.");
        context.setState(new RedLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Yellow to Green.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Traffic light is already Yellow.");
    }
}

class GreenLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Green to Red.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Traffic light is already Green.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transitioning from Green to Yellow.");
        context.setState(new YellowLightState());
    }
}
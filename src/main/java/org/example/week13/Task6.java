package org.example.week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
public class Task6 {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        Coffee espresso = director.constructCoffee(
                new Coffee.EspressoBuilder(), "Espresso", "Small", Arrays.asList("Sugar"));

        Coffee latte = director.constructCoffee(
                new Coffee.LatteBuilder(), "Latte", "Medium", Arrays.asList("Vanilla Syrup", "Whipped Cream"));

        Coffee cappuccino = director.constructCoffee(
                new Coffee.CappuccinoBuilder(), "Cappuccino", "Large", Arrays.asList("Cinnamon", "Chocolate"));

        System.out.println(espresso);
        System.out.println(latte);
        System.out.println(cappuccino);
    }
}


class Coffee{
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(CoffeeBuilder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
    public interface CoffeeBuilder{
        CoffeeBuilder buildType(String type);
        CoffeeBuilder buildSize(String size);
        CoffeeBuilder buildToppings(List<String> toppings);
        Coffee build();
    }

    public static class EspressoBuilder implements CoffeeBuilder{
        private String type;
        private String size;
        private List<String> toppings = new ArrayList<>();

        @Override
        public CoffeeBuilder buildType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public CoffeeBuilder buildSize(String size) {
            this.size = size;
            return this;
        }

        @Override
        public CoffeeBuilder buildToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        @Override
        public Coffee build() {
            return new Coffee(this);
        }
    }

    public static class LatteBuilder implements CoffeeBuilder {
        private String type;
        private String size;
        private List<String> toppings = new ArrayList<>();

        @Override
        public CoffeeBuilder buildType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public CoffeeBuilder buildSize(String size) {
            this.size = size;
            return this;
        }

        @Override
        public CoffeeBuilder buildToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        @Override
        public Coffee build() {
            return new Coffee(this);
        }
    }

    public static class CappuccinoBuilder implements CoffeeBuilder {
        private String type;
        private String size;
        private List<String> toppings = new ArrayList<>();

        @Override
        public CoffeeBuilder buildType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public CoffeeBuilder buildSize(String size) {
            this.size = size;
            return this;
        }

        @Override
        public CoffeeBuilder buildToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        @Override
        public Coffee build() {
            return new Coffee(this);
        }
    }
}

class CoffeeDirector{
    public Coffee constructCoffee(Coffee.CoffeeBuilder builder, String type, String size, List<String> toppings){
        return builder.buildType(type)
                .buildSize(size)
                .buildToppings(toppings)
                .build();
    }
}
 */



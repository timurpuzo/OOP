package org.example.week1;
import java.util.Scanner;
public class week1 {
    //1. Task
    public static void main(String[] args) {
        System.out.printf("My name is Jhon Doe");
    }
}
    /*
    //2. Task
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("(And all the people of the world)");
        //System.out.println("args[0]");
    }
     */
    /*
    3. Task
    public static void main(String[] args){
        int year = 365;
        int seconds = 86400;
        int howMany = year * seconds;
        System.out.println("This is how much there is seconds in a single year: "+ howMany);
    }
     */
    /*
    4. Task
    public static void main(String[] args) {
        Scanner num1 = new Scanner(System.in);
        System.out.println("Enter first number");

        Scanner  num2 = new Scanner(System.in);
        System.out.println("Enter second number");

        int first = Integer.parseInt(num1.nextLine());
        int second = Integer.parseInt(num2.nextLine());
        System.out.println("Sum is: " + (first+second));
    }
     */
    /*
    //5. Task
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.printf("Enter to check number: ");

        int toCheck = Integer.parseInt(num.nextLine());

        if(toCheck > 0){
            System.out.println("Num is bigger than zero");
        }else if(toCheck == 0){
            System.out.println("Num is zero");
        } else{
            System.out.println("Num is smaller than zero");
        }
    }
     */
    /*
    //6. Task
    public static void main(String[] args){
        Scanner first = new Scanner(System.in);
        System.out.println("Enter your first number: ");

        Scanner second = new Scanner(System.in);
        System.out.println("Enter your second number: ");

        int num1 = Integer.parseInt(first.nextLine());
        int num2 = Integer.parseInt(second.nextLine());

        if(num1 > num2){
            System.out.println(num1 + " is bigger than " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " is bigger than " + num1);
        } else if (num1 == num2) {
            System.out.println("They are the same");
        }else {
            System.out.println("ok");
        }
    }
}

     */

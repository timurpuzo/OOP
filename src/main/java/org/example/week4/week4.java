package org.example.week4;
import java.util.List;
import java.util.ArrayList;
/*
public class week4 {

    public static void main(String[] args) {

        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki", 5400);
        System.out.println(pekka);
        System.out.println(esko);

        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");

        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());

        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println(pekka);
        System.out.println(esko);

        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println(olli);
    }

    public static void printDepartment(List<Person> people) {
        for(Person person : people){
            System.out.println(person);
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );
        printDepartment(people);
    }

    public static void main(String[] args){
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 20, "Bosnia");
        System.out.println(pekka);
    }

    public static void main(String[] args){
        Student timur = new Student("Timur Puzo", "Neka ulica", 20, "Bosnia", 1234, 9);
        System.out.println(timur);
    }
}

class Person{
    private String name;
    private String streetName;
    private int age;
    private String country;

    public Person(String name, String streetName, int age, String country){
        this.name = name;
        this.streetName = streetName;
        this.age = age;
        this.country = country;
    }
    public String getName(){
        return name;
    }
    public String getStreetName(){
        return streetName;
    }
    public int getAge(){
        return age;
    }
    public void setName(int new_age){
        this.age = new_age;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String new_country){
        this.country = new_country;
    }
    @Override
    public String toString(){
        return this.name + "\n " + this.streetName + " \n "+  this.age + " \n "+ this.country;
    }
}



class Student extends Person {
    private int credits;
    private int student_id;
    private int grades;

    public Student(String name, String streetName, int age, String country, int student_id, int grades) {
        super(name, streetName, age, country);
        this.credits = 0;
        this.student_id = student_id;
        this.grades = grades;
    }

    public int getCredits() {
        return credits;
    }

    public void study() {
        this.credits++;
    }

    public int getId() {
        return student_id;
    }

    public void setId(int new_id) {
        this.student_id = new_id;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int new_grades) {
        this.grades = new_grades;
    }

    @Override
    public String toString() {
        return super.toString() + "\n " + this.credits + " \n " + this.student_id + " \n " + this.grades;
    }
}


class Teacher extends Person{
    private int salary;

    public Teacher(String name, String streetName, int salary){
        super(name, streetName);
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + this.salary;
    }
}

 */






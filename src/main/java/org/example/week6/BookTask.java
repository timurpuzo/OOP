package org.example.week6;

import java.util.ArrayList;

public class BookTask {
    public static void main(String[] args) {



        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());
        System.out.println(cheese);


        Library Library = new Library();
        //Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        Library.addBook(cheese);
        Book nhl = new Book("NHL Hockey", "Stanley Kupp", 1952);
        Library.addBook(nhl);
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));
        Library.printBooks();

    }


}

class Book{
    private String title;
    private String publisher;
    private int year;

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String title(){
        return title;
    }

    public String publisher(){
        return publisher;
    }

    public int year(){
        return year;
    }
    @Override
    public String toString() {
        return this.title + " " + this.publisher + " " + this.year;
    }
}





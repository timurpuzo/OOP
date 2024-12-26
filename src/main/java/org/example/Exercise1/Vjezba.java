package org.example.Exercise1;

import java.util.ArrayList;
import java.util.HashMap;

public class Vjezba {
    public static void main(String[] args) {
        Library Library = new Library();


        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));


        for (Book book: Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByTitle("PENGUIN  ")) {
            System.out.println(book);
        }

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

    public String title() {
        return title;
    }

    public String publisher() {
        return publisher;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return this.title + " " + this.publisher + " " + this.year;
    }
}

class Library{
    private static ArrayList<Book> library = new ArrayList<Book>();
    public Library() {
    }

    public void addBook(Book newBook){
        library.add(newBook);
    }

    public void printBooks(){
        for(Book b : library){
            System.out.println(b);
        }
    }

    public static ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> found = new ArrayList<>();

        for(Book b : library){
            /*
            if(b.title().equals(title)){
                found.add(b);
            }
             */
            if(StringUtils.included(b.title(),title)){
                found.add(b);
            }
        }
        return found;
    }
}


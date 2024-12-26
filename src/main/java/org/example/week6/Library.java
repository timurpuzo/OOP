package org.example.week6;

import java.util.ArrayList;

public class Library{
    private static ArrayList<Book> library = new ArrayList<>();



    public void addBook(Book newBook){
        library.add(newBook);
    }

    public void printBooks(){
        for(Book book : library){
            System.out.println(book);
        }
    }

//    public ArrayList<Book> searchByTitle(String title) {
//        ArrayList<Book> found = new ArrayList<Book>();
//        for(Book knjiga : found){
//            if(StringUtils.included(knjiga.title(),title)){
//                found.add(knjiga);
//            }
//        }
//        return found;
//    }
}

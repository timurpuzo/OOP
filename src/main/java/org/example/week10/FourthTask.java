package org.example.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FourthTask {
    public static void main(String[] args) {
        List<Song> pjesme = new ArrayList<>();
        pjesme.add(new Song("Afraid","Eminem","Rap"));
        pjesme.add(new Song("Kafanska pjevacica","Sejo Kalac","Narodna"));
        pjesme.add(new Song("Ric flair","Offset","Rap"));
        pjesme.add(new Song("Met Gala","Gucci Mane","Rap"));

        GenreFilterIterator iterator = new GenreFilterIterator(pjesme,"Rap");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Song{
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int index = 0;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
    }

    public boolean hasNext() {
        while(index < playlist.size()){
            if(playlist.get(index).getGenre().equals(targetGenre)){
                return true;
            }index++;
        }return false;
    }

    public Song next(){
        if(hasNext()){
            return playlist.get(index++);
        }else{
            throw new NoSuchElementException("Ne");
        }
    }
}
package org.example.Exercise1;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary{
    private HashMap<String, String> dictionary;

    public Dictionary(HashMap<String, String> dictionary) {
        dictionary = new HashMap<String, String>();
    }

    public String translate(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        return word;
    }
    public int amountWords(){
        return dictionary.size();
    }

    public void add(String word, String translation){
        dictionary.put(word,translation);
    }

    public ArrayList<String> translationList(){
        ArrayList<String> translateList = new ArrayList<String>();

        for(String k : dictionary.keySet()){
            translateList.add(k + " = " + dictionary.get(k));
        }
        return translateList;
    }
}

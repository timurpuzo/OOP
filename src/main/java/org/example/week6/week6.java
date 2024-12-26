package org.example.week6;

import java.util.Collections;

public class week6 {
    /*
    public static void main(String[] args) {
        int[] values = {6, 5, 8, 2, 11};
        System.out.println("smallest: " + smallest(values));
    }
    public static int smallest(int[] array){
        int mali = array[0];
        int index = 0;
        for(int i = 1; i<array.length; i++){
            if(array[i]<mali){
                index = i;
                mali = array[i];
            }
        }

        return index;
    }
     */
    /*
    public static void main(String[] args) {
        int[] values = {6, 5, 8, 2, 11};
        System.out.println("smallest: " + smallest(values));
    }
    public static int smallest(int[] array){
        int mali = array[0];
        for(int i = 1; i<array.length; i++){
            if(array[i]<mali){
                mali = array[i];
            }
        }

        return mali;
    }
     */
    public static void main(String[] args) {
        int[] values = {-1, 6, 9, 8, 12};
        System.out.println(indexOfTheSmallestStartingFrom(values, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values, 4));
    }
    public static int indexOfTheSmallestStartingFrom(int[] array, int index){
        int min = array[index];
        for(int i = index; i< array.length; i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }

}

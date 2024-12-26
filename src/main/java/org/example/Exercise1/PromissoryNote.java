package org.example.Exercise1;

import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> loans;

    public PromissoryNote(){
        loans = new HashMap<String, Double>();
    }

    public void setLoan(String kome, double amount){
        loans.put(kome,amount);
    }

    public double howMuchIsTheDebt(String whose){
        if(loans.containsKey(whose)){
            return loans.get(whose);
        }
        return 0;
    }

}

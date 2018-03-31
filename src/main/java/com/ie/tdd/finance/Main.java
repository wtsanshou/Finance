package com.ie.tdd.finance;

public class Main {
    public  static void main(String[] args){
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        for(int i=0; i<60; ++i){
            System.out.println(i + " : $" + account.startingBalance());
            account = account.nextYear();
        }
    }
}

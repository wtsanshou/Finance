package com.ie.tdd;

public class SavingsAccount {

    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void withdrawal(int amount) {
        balance -= amount;
    }
}

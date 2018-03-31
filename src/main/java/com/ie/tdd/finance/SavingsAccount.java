package com.ie.tdd.finance;

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

    public SavingsAccount nextYear(int interestRate) {
        SavingsAccount result = new SavingsAccount();
        result.deposit(balance() + (balance() * interestRate / 100));
        return result;
    }
}

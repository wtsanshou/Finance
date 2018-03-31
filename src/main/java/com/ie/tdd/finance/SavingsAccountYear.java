package com.ie.tdd.finance;

public class SavingsAccountYear {

    private int startingBalance = 0;
    private int capitalGain = 0;
    private int interestRate = 0;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int capitalGain, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGain = capitalGain;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingBalance() {
        return startingBalance() + (startingBalance() * interestRate / 100);
    }

    public void withdraw(int amount) {
        startingBalance -= amount;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }
}

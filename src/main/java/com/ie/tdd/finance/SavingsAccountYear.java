package com.ie.tdd.finance;

public class SavingsAccountYear {

    private int startingBalance = 0;
    private int startingPrincipal = 0;
    private int interestRate = 0;
    private int capitalGainAmount = 0;
    private int totalWithdrawn = 0;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int startingPrincipal, int interestRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.capitalGainAmount = startingBalance - startingPrincipal;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return startingPrincipal;
    }

    public int interestRate() {
        return interestRate;
    }

    public int totalWithdrawn() {
        return totalWithdrawn;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn();
        return Math.max(0, result);
    }

    public int endingBalance() {
        int modifiedStart = startingBalance() - totalWithdrawn() - capitalGainsTaxIncurred(25);
        return modifiedStart + (modifiedStart * interestRate() / 100);
    }

    public void withdraw(int amount) {
        totalWithdrawn += amount;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate());
    }

    public int capitalGainsWithdrawn() {
        int result = totalWithdrawn() - startingPrincipal();
        return Math.max(0, result);
    }

    public int capitalGainsTaxIncurred(int taxRate) {
        return capitalGainsWithdrawn() * taxRate / 100;
    }
}

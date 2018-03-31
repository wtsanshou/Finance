package com.ie.tdd.finance;

public class SavingsAccountYear {

    private int startingBalance = 0;
    private int capitalGainAmount = 0;
    private int interestRate = 0;
    private int totalWithdraw = 0;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int capitalGainAmount, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainAmount = capitalGainAmount;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return startingBalance - capitalGainAmount;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdraw;
        return (result < 0) ? 0 : result;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingBalance() {
        int modifiedStart = startingBalance - totalWithdraw;
        return modifiedStart + (modifiedStart * interestRate / 100);
    }

    public void withdraw(int amount) {
        totalWithdraw += amount;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }
}

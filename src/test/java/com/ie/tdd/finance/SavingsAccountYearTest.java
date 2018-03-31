package com.ie.tdd.finance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

public class SavingsAccountYearTest {

    @Test
    public void startingBalanceMatchesConstructor() {
        assertEquals(10000, newAccount().startingBalance());
    }

    @Test
    public void interestRateMatchesConstructor(){
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void endingBalanceApplyInterestRate() {
        assertEquals(11000, newAccount().endingBalance());
    }

    @Test
    public void nextYearStartingBalanceEqualsThisYearEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.nextYear().startingBalance(), thisYear.endingBalance());
    }

    @Test
    public void nextYearInterestRateEqualsThisYearInterestRate(){
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.nextYear().interestRate(), thisYear.interestRate());
    }

    @Test
    public void withdrawingFundsAtTheBeginningOfTheYear(){
        SavingsAccountYear year = newAccount();
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance());
    }

    @Test
    public void withdrawingMoreThanPrincipleIncursCapitalGainTax(){
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        year.withdraw(3000);
        assertEquals(7700, year.endingBalance());
        year.withdraw(5000);
        assertEquals(2200 - 1250, year.endingBalance());
    }
    private SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }
}

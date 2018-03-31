package com.ie.tdd.finance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

public class SavingsAccountYearTest {

    @Test
    public void startingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals(10000, account.startingBalance());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals(11000, account.endingBalance());
    }

    @Test
    public void nextYearStartingBalanceShouldEqualsThisYearEndingBalance() {
        SavingsAccountYear thisYear = new SavingsAccountYear(10000, 10);
        assertEquals(thisYear.nextYear().startingBalance(), thisYear.endingBalance());
    }

    @Test
    public void nextYearInterestRateShouldEqualsThisYearInterestRate(){
        SavingsAccountYear thisYear = new SavingsAccountYear(10000, 10);
        assertEquals(thisYear.nextYear().interestRate(), thisYear.interestRate());
    }
}

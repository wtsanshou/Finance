package com.id.tdd;

import com.ie.tdd.SavingsAccount;
import org.junit.Test;
import static org.junit.Assert.*;

public class SavingsAccountTest {

    @Test
    public void depositAndWithdrawal(){
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals("after deposit",100, account.balance());
        account.withdrawal(50);
        assertEquals("after withdrawal",50, account.balance());
    }

    @Test
    public void negativeBalanceIsJustFine(){
        SavingsAccount account = new SavingsAccount();
        account.withdrawal(75);
        assertEquals(-75, account.balance());
    }
}

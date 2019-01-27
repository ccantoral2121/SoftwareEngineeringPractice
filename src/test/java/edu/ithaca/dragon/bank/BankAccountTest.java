package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());

    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        //New test #1
        bankAccount.withdraw(101);
        assertEquals(100, bankAccount.getBalance());
        //New test #2
        bankAccount.withdraw(-1);
        assertEquals(100, bankAccount.getBalance());

    }

    @Test
    void isEmailValidTest(){

        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse( BankAccount.isEmailValid("@.."));
        assertFalse( BankAccount.isEmailValid("@.com"));
        assertFalse( BankAccount.isEmailValid("a@.."));
        assertFalse( BankAccount.isEmailValid("@..com"));
        assertFalse( BankAccount.isEmailValid("d@..com"));
        assertFalse( BankAccount.isEmailValid("a@@b.com"));
        assertFalse( BankAccount.isEmailValid("a@.com.com"));


    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

    @Test

    void isAmountValid(){


        assertTrue(BankAccount.isAmountValid(10.00));
        assertTrue(BankAccount.isAmountValid(0.01));
        assertTrue(BankAccount.isAmountValid(0.1));

        assertFalse(BankAccount.isAmountValid(10.001));
        assertFalse(BankAccount.isAmountValid(-1));


    }

}
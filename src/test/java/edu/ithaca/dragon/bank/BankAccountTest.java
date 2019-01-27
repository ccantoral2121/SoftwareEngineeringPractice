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
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        //New test using exception InsufficientFundException
        assertThrows(InsufficientFundsException.class, ()-> bankAccount.withdraw(101));
        //Negative test using exception InsufficientFundException
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-1));
        //Decimal test
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(0.001));

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
        BankAccount bankAccount = new BankAccount("a@b.com", 100);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(100, bankAccount.getBalance());

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -50));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 20.022));

    }

    @Test

    void isAmountValidTest(){


        assertTrue(BankAccount.isAmountValid(10));
        assertTrue(BankAccount.isAmountValid(10.00));
        assertTrue(BankAccount.isAmountValid(0.01));
        assertTrue(BankAccount.isAmountValid(0.1));

        assertFalse(BankAccount.isAmountValid(10.001));
        assertFalse(BankAccount.isAmountValid(-1));


    }

}
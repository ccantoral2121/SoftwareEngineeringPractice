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
        /*An email is valid if it has a domain name, .com/.net/.edu/ etc
          at the end. and has a name before the @ symbol.
        */
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

}
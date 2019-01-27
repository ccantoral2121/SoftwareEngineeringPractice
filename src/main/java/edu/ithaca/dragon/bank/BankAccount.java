package edu.ithaca.dragon.bank;
//use to validate isEmailValid
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {

        if (amount <= balance && amount > 0){
            balance -= amount;
        }

    }

    /**
     * @post an Email is valid if it has a domain name, .com/.net/.edu/ etc
     *       at the end. and has a name before the @ symbol.
     *
     * @param email
     *
     **/

    public static boolean isEmailValid(String email){


        //Email Regex
        String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern;
        Matcher matcher;
        //initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);
        //returns validation
        return matcher.matches();

    }

    /**
     * @post takes a double and returns true it the amount is positive and has two decimal
     *       points or less, and false otherwise
     */

    public static boolean isAmountValid(double amount){

        if(amount < 0){
            return false;
        }

        String num = String.valueOf(amount);
        int i = num.lastIndexOf('.');

        if( i != -1 && num.substring( i + 1 ).length() <= 2){
            return true;
        }else{
            return false;
        }

    }

}



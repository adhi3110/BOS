package com.bos.Business;
import com.bos.Exceptions.InvalidAccountTypeException;

//SRP of Account Factory
//To create different accounts

public class AccountFactory {

    public static IAccount create(String type) throws InvalidAccountTypeException {

        //1. Account variable Initialization
        IAccount account = null;

        //2. Create an account for the type passed
        //Check if type is not null
        if(type != null)
            if(type.equals("Savings")){
                account = new Savings();
            }
            else if(type.equals("Current")){
                account = new Current();
            }
            else
                throw new InvalidAccountTypeException("Invalid Account Type");

        //3. Return the account instance
        return account;

    }
}

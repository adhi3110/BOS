package com.bos.Business;
import java.time.LocalDate;

import com.bos.Exceptions.AccountClosedException;
import com.bos.Exceptions.InsuffcientBalanceException;
import com.bos.Exceptions.InvalidAgeException;
import com.bos.Exceptions.InvalidRegistrationNoException;

public interface IAccount {


     void setName(String name);
     void setPinNo(int pinNo);
     void setAccountNo(int accountNo);
     int getAccountNo();
     void setBalance(double balance);
     double getBalance();
     boolean getisActive();
     int getPinNo();
     void setPrivilege(Privilege privilege);
     Privilege getPrivilege();

     void open() throws InvalidAgeException,InvalidRegistrationNoException;
     void close() throws AccountClosedException;
     boolean withdraw(double amt) throws AccountClosedException, InsuffcientBalanceException;
     boolean deposit(double amt) throws AccountClosedException;




}

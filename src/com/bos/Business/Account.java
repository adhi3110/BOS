package com.bos.Business;
import java.time.LocalDate;

import com.bos.Exceptions.AccountClosedException;
import com.bos.Exceptions.InsuffcientBalanceException;


public abstract class Account implements IAccount{

    private int accountNo;
    private String Name;
    private int pinNo;
    private double balance;
    private boolean isActive;
    private LocalDate activitedDate;
    private LocalDate closedDate;
    private Privilege privilege;

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPinNo() {
        return pinNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getActivitedDate() {
        return activitedDate;
    }

    public void setActivitedDate(LocalDate activitedDate) {
        this.activitedDate = activitedDate;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    @Override
    public void close() throws AccountClosedException {
        if(this.isActive){
            this.isActive = false;
            this.closedDate = LocalDate.now();
        }
        else
            throw new AccountClosedException("Account already closed");
    }

    @Override
    public boolean withdraw(double amt) throws AccountClosedException, InsuffcientBalanceException {

        boolean success = false;
        if(!this.isActive)
            throw new AccountClosedException("Account already close");
        else if(this.balance < amt)
            throw new InsuffcientBalanceException("Insuffcient Balance");
        else {
            success = true;
            this.balance -= amt;
        }
        return success;
    }

    @Override
    public boolean deposit(double amt) throws AccountClosedException {

        boolean success = false;
        if(!this.isActive) {
            throw new AccountClosedException("Account already close");
        }
        else {
            success = true;
            this.balance += amt;
        }
        return success;
    }
}

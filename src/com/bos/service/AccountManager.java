package com.bos.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.bos.Business.AccountFactory;
import com.bos.Business.IAccount;
import com.bos.Business.Savings;
import com.bos.Business.*;
import com.bos.Exceptions.*;

public class AccountManager {

    private static int accountCount = 0;
    public static HashMap<Integer, IAccount> accounts= new HashMap<>();


    public static int getAccountCount() {
        return accountCount;
    }

    public static void incAccountCount() {
        accountCount++;
    }

    public static void addAccount(IAccount a){
        accounts.put(a.getAccountNo(),a);
    }

    public boolean open(String type,String name, int pinno, Privilege p, double balance,String[] details) throws InvalidAccountTypeException {



        IAccount account = AccountFactory.create(type);
        account.setName(name);
        account.setPinNo(pinno);
        account.setPrivilege(p);
        account.setBalance(balance);

        if(account instanceof Savings) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dob = LocalDate.parse(details[0], dtf);


            ((Savings)account).setDateOfBirth(dob);
            ((Savings)account).setGender(details[1]);
            ((Savings)account).setPhoneNo(details[2]);
            account.setAccountNo(accountCount);
            accountCount++;

            try {
                account.open();
            } catch (Exception | InvalidRegistrationNoException e) {
                System.out.println(e.getMessage());
            }
        }

        if(account instanceof Current){

            ((Current)account).setCompanyName(details[0]);
            ((Current)account).setWebsite(details[1]);
            ((Current)account).setRegistrationNo(details[2]);

            try{
                account.open();
            }catch (Exception | InvalidRegistrationNoException e) {
                System.out.println(e.getMessage());
            }


        }
        accounts.put(account.getAccountNo(),account);
        return true;
    }

    public void close(int accNo) throws AccountClosedException {
        IAccount account = accounts.get(accNo);
        account.close();
    }

    public void withdraw(int accNo,double amt) throws InsuffcientBalanceException, AccountClosedException {
        IAccount account = accounts.get(accNo);
        account.withdraw(amt);
    }

    public void deposit(int accNo,double amt) throws AccountClosedException {

        IAccount account = accounts.get(accNo);
        account.deposit(amt);
    }

    public boolean transferFunds(int fromAccNo,int toAccNo,double amt, TransferMode t,int pin) throws AccountClosedException, InsuffcientBalanceException, InvalidPinException, InsuffcientLimitException {




        IAccount fromAccount = accounts.get(fromAccNo);
        IAccount toAccount = accounts.get(toAccNo);

        TranferLog l = new TranferLog();
        l.setFromAcc(fromAccount);
        l.setToAcc(toAccount);
        l.setAmt(amt);
        l.setTransferMode(t);
        l.setDate(LocalDate.now());

        if(fromAccount.getisActive() && toAccount.getisActive()){
            if(fromAccount.getBalance() >= amt){
                if(fromAccount.getPinNo() == pin){
                    if(fromAccount.getPrivilege().getLimit() > amt + TransferLogManager.getLimit(LocalDate.now(),fromAccNo)){
                        fromAccount.withdraw(amt);
                        toAccount.deposit(amt);
                        TransferLogManager.addlog(l);
                        return true;
                    }
                    else
                        throw new InsuffcientLimitException("Insufficient Limit!!" + "Remaining Limit =>" + (fromAccount.getPrivilege().getLimit() - TransferLogManager.getLimit(LocalDate.now(),fromAccNo)) );
                }
                else
                    throw new InvalidPinException("Wrong Pin");
            }
            else
                throw new InsuffcientBalanceException("Insufficient Balance");
        }
        else
            throw new AccountClosedException("Account Inactive");

    }




}

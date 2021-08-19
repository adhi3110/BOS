package com.bos.UI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

import com.bos.Business.Privilege;
import com.bos.Business.TransferMode;
import com.bos.Exceptions.*;
import com.bos.service.*;

public class AccountManagerInput {

    AccountManager acc = new AccountManager();
    Scanner kybd = new Scanner(System.in);
    public void open() throws InvalidAccountTypeException {
        System.out.println("Enter type of account (Savings/Current) :");
        String type = kybd.next();

        System.out.println("Enter Name :");
        String name = kybd.next();
        System.out.println("Enter Pin :");
        int pinno = kybd.nextInt();
        System.out.println("Enter Privilege");
        Privilege p = Privilege.valueOf(kybd.next());
        System.out.println("Enter balance:");
        double balance = kybd.nextDouble();
        String[] details = new String[3];

        if(type.equals("Savings")){


            System.out.println("Enter Date of Birth (dd/mm/yyyy):");
            String birthday = kybd.next();

            System.out.println("Enter gender :");
            String gen = kybd.next();

            System.out.println("Enter phno :");
            String phno = kybd.next();

            details[0] = birthday;
            details[1] = gen;
            details[2] = phno;

        }
        else if (type.equals("Current")){
            System.out.println("Enter Company Name :");
            String comapnyName = kybd.next();

            System.out.println("Enter website :");
            String website = kybd.next();

            System.out.println("Enter gender :");
            String registrationNo = kybd.next();

            details[0] = comapnyName;
            details[1] = website;
            details[2] = registrationNo;
        }
        else
            throw new InvalidAccountTypeException("Invalid Account type");

        if(acc.open(type, name, pinno, p, balance,details))
            System.out.println("Account Opened");
    }


    public void close() throws AccountClosedException {
        System.out.println("Enter Account Number");
        int accNo = kybd.nextInt();
        acc.close(accNo);
    }

    public void withdraw() throws InsuffcientBalanceException, AccountClosedException {
        System.out.println("Enter Account Number");
        int accNo = kybd.nextInt();
        System.out.println("Enter Amount to withdraw");
        double amt = kybd.nextDouble();
        acc.withdraw(accNo,amt);
    }


    public void deposit() throws AccountClosedException {
        System.out.println("Enter Account Number");
        int accNo = kybd.nextInt();
        System.out.println("Enter Amount to Deposit");
        double amt = kybd.nextDouble();
        acc.deposit(accNo,amt);
    }

    public void transferFunds() throws InsuffcientBalanceException, InsuffcientLimitException, AccountClosedException, InvalidPinException {

        System.out.println("Enter From Account Number");
        int fromAccNo = kybd.nextInt();
        System.out.println("Enter To Account Number");
        int toAccNo = kybd.nextInt();
        System.out.println("Enter Amount to transfer");
        double amt = kybd.nextDouble();
        System.out.println("Enter Pin to transfer");
        int pin = kybd.nextInt();
        System.out.println("Enter type of transfer");
        TransferMode t = TransferMode.valueOf(kybd.next());

        if(acc.transferFunds(fromAccNo,toAccNo,amt,t,pin))
            System.out.println("Done!!");
    }

    public void display(){
        AccountManager.accounts.forEach((k, v) -> System.out.println(k + " : " +v.getBalance()+":"+v.getisActive()));
    }
}

package com.bos.UI;
import java.util.Scanner;
import com.bos.Exceptions.*;
//import com.bos.Business.*;
import com.bos.service.*;

public class MainMenu {

    AccountManagerInput acc = new AccountManagerInput();

    Scanner kybd = new Scanner(System.in);

    public void run(){
        System.out.println("Choose:");
        System.out.println("1 => Open:");
        System.out.println("2 => Close:");
        System.out.println("3 => Withdraw:");
        System.out.println("4 => Deposit");
        System.out.println("5 => Transfer");
        System.out.println("6 => Display");
        System.out.println("7 => Exit");
        switch (kybd.nextInt()){
            case 1 :
                try {
                    acc.open();
                } catch (Exception | InvalidAccountTypeException e) {
                    System.out.println(e.getMessage());
                } break;
            case 2:
                try {

                    acc.close();
                }catch (Exception | AccountClosedException e){
                    System.out.println(e.getMessage());
                } break;
            case 3:
                try{
                    acc.withdraw();
                    System.out.println("DONE!!");
                }catch (Exception | InsuffcientBalanceException | AccountClosedException e){
                    System.out.println(e.getMessage());
                } break;
            case 4:
                try{
                    acc.deposit();
                    System.out.println("DONE!!");
                }catch (Exception | AccountClosedException e){
                    System.out.println(e.getMessage());
                } break;

            case 5:
                try {
                    acc.transferFunds();
                } catch (Exception | AccountClosedException | InsuffcientBalanceException | InvalidPinException | InsuffcientLimitException e){
                    System.out.println(e.getMessage());
                }break;
            case 6:
                acc.display();break;
            case 7:
                System.exit(0);
            default: System.out.println("Invalid Choice");break;
        }
    }
}

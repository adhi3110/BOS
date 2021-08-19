package com.bos.Business;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TransferLogManager {

    public static HashMap<LocalDate , ArrayList<TranferLog>> logs = new HashMap<>();

    public static void addlog(TranferLog l){
        ArrayList<TranferLog> L = logs.get(LocalDate.now());
        if(L ==null)
            L = new ArrayList<>();
        L.add(l);
        logs.put(LocalDate.now(),L);
    }

    public static double getLimit(LocalDate date, int accNo){
        ArrayList<TranferLog> L = logs.get(date);
        double sum =0;
        if(L == null)
            return 0;
        for(TranferLog l:L){
            if(l.getFromAcc().getAccountNo() == accNo){
                sum += l.getAmt();
            }
        }
        return sum;
    }
}

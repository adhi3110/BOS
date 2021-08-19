package com.bos.Business;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class logManager {

    public static HashMap<LocalDate , ArrayList<log>> logs = new HashMap<>();

    public static void addlog(log l){
        ArrayList<log> L = logs.get(LocalDate.now());
        if(L ==null)
            L = new ArrayList<>();
        L.add(l);
        logs.put(LocalDate.now(),L);
    }

    public static double getLimit(LocalDate date, int accNo){
        ArrayList<log> L = logs.get(date);
        double sum =0;
        if(L == null)
            return 0;
        for(log l:L){
            if(l.getFromAcc().getAccountNo() == accNo){
                sum += l.getAmt();
            }
        }
        return sum;
    }
}

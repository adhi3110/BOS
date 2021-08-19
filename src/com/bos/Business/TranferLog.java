package com.bos.Business;
import java.time.LocalDate;


public class TranferLog {

    private IAccount fromAcc;
    private IAccount toAcc;
    private double amt;
    private TransferMode transferMode;
    private LocalDate date;



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public IAccount getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(IAccount fromAcc) {
        this.fromAcc = fromAcc;
    }

    public IAccount getToAcc() {
        return toAcc;
    }

    public void setToAcc(IAccount toAcc) {
        this.toAcc = toAcc;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public TransferMode getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(TransferMode transferMode) {
        this.transferMode = transferMode;
    }


}

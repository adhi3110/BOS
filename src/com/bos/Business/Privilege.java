package com.bos.Business;
public enum Privilege {

    PLATINUM(100000),
    GOLD(50000),
    SILVER(25000);

    private final double transferLimit;
    Privilege(double transferLimit){
        this.transferLimit = transferLimit;
    }

    public double getLimit() {
        return this.transferLimit;
    }
}


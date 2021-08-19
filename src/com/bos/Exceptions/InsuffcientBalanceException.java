package com.bos.Exceptions;
import com.bos.Logger.Logger;

public class InsuffcientBalanceException extends Throwable {
    public InsuffcientBalanceException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

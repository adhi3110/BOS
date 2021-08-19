package com.bos.Exceptions;
import com.bos.Logger.logger;

public class InsuffcientBalanceException extends Throwable {
    public InsuffcientBalanceException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

package com.bos.Exceptions;
import com.bos.Logger.logger;

public class AccountClosedException extends Throwable {
    public AccountClosedException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

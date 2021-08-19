package com.bos.Exceptions;
import com.bos.Logger.Logger;

public class AccountClosedException extends Throwable {
    public AccountClosedException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

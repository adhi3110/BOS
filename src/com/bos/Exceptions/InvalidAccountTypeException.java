package com.bos.Exceptions;
import com.bos.Logger.logger;
public class InvalidAccountTypeException extends Throwable {
    public InvalidAccountTypeException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

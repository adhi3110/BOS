package com.bos.Exceptions;
import com.bos.Logger.Logger;
public class InvalidAccountTypeException extends Throwable {
    public InvalidAccountTypeException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

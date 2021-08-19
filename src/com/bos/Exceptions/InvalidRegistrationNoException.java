package com.bos.Exceptions;
import com.bos.Logger.logger;
public class InvalidRegistrationNoException extends Throwable {
    public InvalidRegistrationNoException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

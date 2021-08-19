package com.bos.Exceptions;
import com.bos.Logger.Logger;
public class InvalidRegistrationNoException extends Throwable {
    public InvalidRegistrationNoException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

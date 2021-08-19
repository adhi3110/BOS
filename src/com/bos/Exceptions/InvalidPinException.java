package com.bos.Exceptions;
import com.bos.Logger.logger;
public class InvalidPinException extends Throwable {
    public InvalidPinException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

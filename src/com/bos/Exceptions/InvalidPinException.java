package com.bos.Exceptions;
import com.bos.Logger.Logger;
public class InvalidPinException extends Throwable {
    public InvalidPinException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

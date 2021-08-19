package com.bos.Exceptions;
import com.bos.Logger.Logger;

public class InsuffcientLimitException extends Throwable {
    public InsuffcientLimitException(String msg) {
        super(msg);
        Logger.logger.warning(msg);
    }
}

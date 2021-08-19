package com.bos.Exceptions;
import com.bos.Logger.logger;

public class InsuffcientLimitException extends Throwable {
    public InsuffcientLimitException(String msg) {
        super(msg);
        logger.logger.warning(msg);
    }
}

package com.bos.Exceptions;
import com.bos.Logger.logger;
public class InvalidAgeException extends Exception{
    public InvalidAgeException(String msg){
        super(msg);
        logger.logger.warning(msg);
    }
}

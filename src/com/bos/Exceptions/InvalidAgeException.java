package com.bos.Exceptions;
import com.bos.Logger.Logger;
public class InvalidAgeException extends Exception{
    public InvalidAgeException(String msg){
        super(msg);
        Logger.logger.warning(msg);
    }
}

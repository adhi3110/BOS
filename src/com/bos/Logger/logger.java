package com.bos.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class logger {


    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("MyLog");
    static FileHandler fh;

    static {
        try {
            fh = new FileHandler("C:/Training/BOS.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);
            // the following statement is
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


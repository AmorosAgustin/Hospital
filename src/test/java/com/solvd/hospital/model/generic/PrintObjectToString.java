package com.solvd.hospital.model.generic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintObjectToString<U> {
    private final static Logger log = LogManager.getLogger(PrintObjectToString.class);

    public void print(U u) {

        log.info("Here i print the object using its toString method");
        log.info(u.toString());

    }


}

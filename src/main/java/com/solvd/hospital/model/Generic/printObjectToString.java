package com.solvd.hospital.model.Generic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class printObjectToString<U> {
    private final static Logger log = LogManager.getLogger(printObjectToString.class);

public void print(U u){

    log.info("Here i print the object using its toString method");
    System.out.print(u.toString());

}



}

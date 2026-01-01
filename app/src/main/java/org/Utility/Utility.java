package org.Utility;

import java.util.UUID;

public class Utility {

    //  Method to return UUID
    public static String getUUID(){
        String uuid = String.valueOf(UUID.randomUUID());
        return uuid ;
    }

}

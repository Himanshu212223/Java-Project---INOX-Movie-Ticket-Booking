package org.Utility;

import java.util.UUID;

public class Utility {

    public static String getUUID(){
        String uuid = String.valueOf(UUID.randomUUID());
        return uuid ;
    }

}

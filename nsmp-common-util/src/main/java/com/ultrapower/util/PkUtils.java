package com.ultrapower.util;

import java.util.UUID;

public class PkUtils {

    public static String getUUID(){
        String str = UUID.randomUUID().toString().replace("-", "");
        return str;
    }
}

package com.jamie.rms.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ObjectUtil {

	final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static DateFormat sdf_onlyDate = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isNotNullEmpty(String string) {
        return string != null && !string.equals("") && !string.equals("null") && !string.isEmpty() && !string.trim().isEmpty();
    }

    public static  boolean isNullEmpty(String data){
        boolean result = false;

        if(data == null || "".equals(data) || data.isEmpty()){
            result = true;
        }

        return result;
    }
    
}

package com.jamie.rms.common;

public class ResponseStatus {
	final static String successful = "SUCCESSFUL";
    final static String fail = "FAIL";

    public static String getSuccessful() {
        return successful;
    }

    public static String getFail() {
        return fail;
    }
}

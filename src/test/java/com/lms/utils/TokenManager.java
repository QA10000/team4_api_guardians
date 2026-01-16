package com.lms.utils;

public class TokenManager {
    private static String authToken;
    private static String newBatchId;


    public static void saveToken(String token) {
        authToken = token;
    }


    public static String getToken() {
        return authToken;
    }


    public static boolean hasToken() {
        return authToken != null && !authToken.isEmpty();
    }


    public static void clearToken() {
        authToken = null;
        System.out.println("Token cleared");
    }
    public static void saveBatchId(String batchId)
    {
         newBatchId = batchId;
    }
    public static String getBatchId() { return newBatchId; }

}

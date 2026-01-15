package com.lms.utils;

public class SesionManager {
    private static String authToken;
    

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
}

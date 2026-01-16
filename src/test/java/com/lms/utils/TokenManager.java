package com.lms.utils;

public class TokenManager {
    //LOGIN Variable
    private static String authToken;

    //User Variable
    private static String newUserId;
    private static String newskillId;
    private static String newRoleId;
    private static String newBatchId;
    private static String newProgramId;

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

    public static void saveUserId(String userId) {
        newUserId = userId;
    }

    public static String getUserId() {
        return newUserId;
    }

    public static void saveRoleId(String roleId) {
        newRoleId = roleId;
    }

    public static String getRoleId() {
        return newRoleId;
    }

    public static void saveSkillId(String skillId) {
        newskillId = skillId;
    }

    public static String getSkillId() {
        return newskillId;
    }

    public static void saveProgramId(String programId) {
        newProgramId = programId;
    }

    public static String getProgramId() {
        return newProgramId;
    }

    public static void saveBatchId(String batchId) {
        newBatchId = batchId;
    }

    public static String getBatchId() {
        return newBatchId;
    }

}

package com.pmgt.krish.enums;

public enum ResultState {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),

    LOGIN_FAIL(420, "Login Failed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int resultCode;
    private final String resultMessage;

    ResultState(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
package com.morelllcrm.exception;

public class UserNotVerifiedExceptionResponse {
    private String userNotVerified;

    public UserNotVerifiedExceptionResponse(String userNotVerified) {
        this.userNotVerified = userNotVerified;
    }

    public String getUserNotVerified() {
        return userNotVerified;
    }

    public void setUserNotVerified(String userNotVerified) {
        this.userNotVerified = userNotVerified;
    }

}

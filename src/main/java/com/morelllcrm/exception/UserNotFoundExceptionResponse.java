package com.morelllcrm.exception;

public class UserNotFoundExceptionResponse {
    public String getUserNotFound() {
        return userNotFound;
    }

    public void setUserNotFound(String userNotFound) {
        this.userNotFound = userNotFound;
    }

    private String userNotFound;
    public UserNotFoundExceptionResponse(String userNotFound) {
        this.userNotFound=userNotFound;
    }
}

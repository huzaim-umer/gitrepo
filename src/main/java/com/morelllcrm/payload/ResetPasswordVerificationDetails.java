package com.morelllcrm.payload;

import java.time.LocalDateTime;

public class ResetPasswordVerificationDetails {
    private String to;
    private String userName;
    private LocalDateTime date;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

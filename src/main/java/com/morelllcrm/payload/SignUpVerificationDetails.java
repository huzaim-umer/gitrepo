package com.morelllcrm.payload;

import java.util.UUID;

public class SignUpVerificationDetails {
    private String subject;
    private String to;
    private UUID activation_id;
    private Long user_id;
    public String getTo() {
        return to;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public UUID getActivation_id() {
        return activation_id;
    }
    public void setActivation_id(UUID activation_id) {
        this.activation_id = activation_id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getDays() {
        return days;
    }
    public void setDays(String days) {
        this.days = days;
    }
    private String userName;
    private String link;
    private String days;

}

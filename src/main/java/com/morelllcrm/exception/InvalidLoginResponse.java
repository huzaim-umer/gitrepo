package com.morelllcrm.exception;

public class InvalidLoginResponse {

    public String InvalidLoginResponse() {
        //String res = "Please provide a valid username or password";
        String res = "Please provide a valid username or password or Please verify your email to login ";
        return res;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


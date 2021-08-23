package com.morelllcrm.payload;

public class JwtTokenSuccessResponse {

    private String token;
    private Boolean success;

    public JwtTokenSuccessResponse(String token, Boolean success) {
        this.token = token;
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "JwtTokenSuccessResponse{" +
                "token='" + token + '\'' +
                ", success=" + success +
                '}';
    }
}

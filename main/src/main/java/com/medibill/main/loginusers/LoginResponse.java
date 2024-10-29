package com.medibill.main.loginusers;

public class LoginResponse {
    private LoginUsers userName;
    private String token;

    public LoginResponse(){
        super();
    }

    public LoginResponse(LoginUsers userName, String token){
        this.userName = userName;
        this.token = token;
    }

    public LoginUsers getUserName() {
        return userName;
    }

    public void setUserName(LoginUsers userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

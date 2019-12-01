package com.netcracker.edu.backend.entity;

public class LoginMessage {

    private String loginMessage;

    public LoginMessage() {
    }

    public LoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
}

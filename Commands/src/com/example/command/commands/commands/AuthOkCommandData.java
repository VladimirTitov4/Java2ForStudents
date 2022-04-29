package com.example.command.commands.commands;

import java.io.Serializable;

public class AuthOkCommandData implements Serializable {

    private final String userName;

    public AuthOkCommandData(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

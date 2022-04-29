package com.example.command.commands.commands;

import java.io.Serializable;

public class PublicMessageCommandData implements Serializable {

    private final String message;

    public PublicMessageCommandData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

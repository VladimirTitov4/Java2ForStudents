package com.example.clientchat.model;

import com.example.command.Command;

public interface ReadMessageListener {

    void processReceivedCommand(Command command);

}

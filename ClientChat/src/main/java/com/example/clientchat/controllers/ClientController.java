package com.example.clientchat.controllers;

import com.example.clientchat.ClientChat;
import com.example.clientchat.Network;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    public TextField messageTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView userList;

    private ClientChat application;

    public void sendMessage() {
        String message = messageTextArea.getText();
        chatTextArea.appendText(DateFormat.getTimeInstance().format(new Date()) + " ");
        messageTextArea.requestFocus();
        appendMessageToChat(message);
        try {
            Network.getInstance().sendMessage(message);
        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данных по сети");
        }
    }

    public void appendMessageToChat(String message) {
        if (!message.isEmpty()) {
            chatTextArea.appendText(message);
            chatTextArea.appendText(System.lineSeparator());
            messageTextArea.clear();
        }
    }

    public void initializeMessageHandler() {
        Network.getInstance().waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat(message);
            }
        });
    }

    public ClientChat getApplication() {
        return application;
    }

    public void setApplication(ClientChat application) {
        this.application = application;
    }
}
package com.example.clientchat.controllers;

import com.example.clientchat.dialogs.Dialogs;
import com.example.clientchat.model.Network;
import com.example.clientchat.model.ReadMessageListener;
import com.example.command.Command;
import com.example.command.CommandType;
import com.example.command.commands.commands.ClientMessageCommandData;
import com.example.command.commands.commands.UpdateUserListCommandData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ClientController {

    @FXML
    public TextField messageTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView userList;

    public void sendMessage() {
        String message = messageTextArea.getText();

        if (message.isEmpty()) {
            messageTextArea.clear();
            return;
        }

        String sender = null;
        if (!userList.getSelectionModel().isEmpty()) {
            sender = userList.getSelectionModel().getSelectedItem().toString();
        }

        try {
            if (sender != null) {
                Network.getInstance().sendPrivateMessage(sender, message);
            } else {
                Network.getInstance().sendMessage(message);
            }

        } catch (IOException e) {
            Dialogs.NetworkError.SEND_MESSAGE.show();
        }

        appendMessageToChat("Я", message);
    }

    public void appendMessageToChat(String sender, String message) {
        chatTextArea.appendText(DateFormat.getInstance().format(new Date()));
        chatTextArea.appendText(System.lineSeparator());

        if (sender != null) {
            chatTextArea.appendText(sender + ":");
            chatTextArea.appendText(System.lineSeparator());
        }

        chatTextArea.appendText(message);
        chatTextArea.appendText(System.lineSeparator());
        chatTextArea.appendText(System.lineSeparator());
        requestFocusForTextArea();
        messageTextArea.clear();
    }

    private void requestFocusForTextArea() {
        Platform.runLater(() -> messageTextArea.requestFocus());
    }

    public void initializeMessageHandler() {
        Network.getInstance().addReadMessageListener(new ReadMessageListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.CLIENT_MESSAGE) {
                    ClientMessageCommandData data = (ClientMessageCommandData) command.getData();
                    appendMessageToChat(data.getSender(), data.getMessage());
                } else if (command.getType() == CommandType.UPDATE_USERS_LIST) {
                    UpdateUserListCommandData data = (UpdateUserListCommandData) command.getData();
                    Platform.runLater(() -> {
                        userList.setItems(FXCollections.observableArrayList(data.getUsers()));
                    });
                }

            }
        });
    }
}
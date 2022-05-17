package com.example.clientchat.dialogs;

import com.example.clientchat.ClientChat;
import javafx.scene.control.Alert;

public class Dialogs {

    public enum AuthError {
        EMPTY_CREDENTIALS("Логин и пароль должны быть указаны"),
        INVALID_CREDENTIALS("Логин и пароль заданы некорректно");

        private static final String TITLE = "Ошибка аутентификации";
        private static final String TYPE = TITLE;

        private final String message;

        AuthError(String message) {
            this.message = message;
        }

        public void show() {
            showDialog(Alert.AlertType.ERROR, TITLE, TYPE, message);
        }
    }

    public enum AuthTimeout{
        AUTH_TIMEOUT("Время на авторизацию в чате истекло. Повторите вход");

        private static final String TITLE = "Время на авторизацию истекло";
        private static final String TYPE = TITLE;

        private final String message;

        AuthTimeout(String message) {
            this.message = message;
        }

        public void show(){
            showDialog(Alert.AlertType.WARNING, TITLE, TITLE, message);
        }
    }

    public enum NetworkError {
        SEND_MESSAGE("Не удалось отправить сообщение!"),
        SERVER_CONNECT("Не удалось установить соединение с сервером!");

        private static final String TITLE = "Сетевая ошибка";
        private static final String TYPE = "Ошибка передачи данных по сети";
        private final String message ;

        NetworkError(String message) {
            this.message = message;
        }

        public void show() {
            showDialog(Alert.AlertType.ERROR, TITLE, TYPE, message);
        }

    }

    private static void showDialog(Alert.AlertType dialogType, String title, String type, String message) {
        Alert alert = new Alert(dialogType);
        alert.initOwner(ClientChat.getInstance().getChatStage());
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

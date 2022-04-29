package com.geekbrains.lesson6.homework.invert;

import com.geekbrains.lesson6.homework.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {
        new Client().start(Network.HOST, Network.PORT);
    }

    public void start(String host, int port) throws IOException {
        try (Socket socket = new Socket(host, port);) {
            System.out.println("Клиент запущен");
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());

            readMessages();
            sendMessages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }

    private void sendMessages() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String message = scanner.nextLine();
                    try {
                        outputStream.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (message.startsWith("/end")) {
                        break;
                    }
                }
            }
        }).start();
    }

    private void readMessages() throws IOException {
        while (true) {
            try {
                String message = inputStream.readUTF();
                if (message.toLowerCase().startsWith("/end")) {
                    System.out.println("Сервер завершил свою работу");
                    System.exit(0);
                }
                System.out.println("From server: " + message);
            } catch (IOException e) {
                System.out.println("подключение прервано");
                System.exit(0);
            }
        }
    }
}

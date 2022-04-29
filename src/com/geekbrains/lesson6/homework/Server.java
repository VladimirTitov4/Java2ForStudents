package com.geekbrains.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {
        new Server().start(Network.PORT);
    }

    public void start(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            readMessages();
            sendMessages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }

    private void readMessages() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = inputStream.readUTF();
                    if (message.toLowerCase().startsWith("/end")) {
                        System.out.println("Клиент отключился");
                        System.exit(0);
                    }
                    System.out.println("From client: " + message);
                } catch (IOException e) {
                    System.out.println("подключение прервано");
                    System.exit(0);
                    break;
                }
            }
        }).start();
    }

    private void sendMessages() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            outputStream.writeUTF(message);
            if (message.startsWith("/end")) {
                break;
            }
        }
    }
}

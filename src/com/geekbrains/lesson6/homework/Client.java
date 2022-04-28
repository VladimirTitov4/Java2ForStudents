package com.geekbrains.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        new Client().start("localhost", 8150);
    }

    public void start(String host, int port) throws IOException {
        Socket socket = null;
        Thread inputThread = null;

        try {
            socket = new Socket(host, port);
            System.out.println("Клиент запущен");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            inputThread = runInputLoop(inputStream);
            runOutputLoop(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) {
                inputThread.interrupt();
            }
            if (socket != null) {
                socket.close();
            }
        }

    }

    private Thread runInputLoop(DataInputStream inputStream) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = inputStream.readUTF();
                    System.out.println("From server: " + message);
                    if (message.startsWith("/end")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("подключение прервано");
                    System.exit(0);
                    break;
                }
            }

        });
        thread.start();
        return thread;
    }

    private void runOutputLoop(DataOutputStream outputStream) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.startsWith("/end")) {
                break;
            }
            outputStream.writeUTF(message);
        }
    }
}

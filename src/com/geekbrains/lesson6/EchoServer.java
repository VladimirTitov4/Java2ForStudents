package com.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер начал работу, ожидаем новые подключения");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream()); // чтение
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream()); // запись

            processClientConnection(inputStream, outputStream);

        } catch (IOException e) {
            System.err.println("Ошибка при подключении к порту " + PORT);
            e.printStackTrace();
        }
    }

    private static void processClientConnection(DataInputStream inputStream, DataOutputStream outputStream) {
        while (true) {
            try {
                String message = inputStream.readUTF();
                if (message.startsWith("/end")) {
                    break;
                }
                outputStream.writeUTF("Echo: " + message);
            } catch (IOException e) {
                System.out.println("Сетевое соединение было закрыто");
                break;
            }
        }
    }
}

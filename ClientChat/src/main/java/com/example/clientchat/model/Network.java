package com.example.clientchat.model;

import com.example.command.Command;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Network {

    private List<ReadMessageListener> listeners = new CopyOnWriteArrayList<>();

    private static Network INSTANCE;
    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 8189;

    private String host;
    private int port;

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Thread readMessageProcess;
    private boolean connected;

    private Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public static Network getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Network();
        }

        return INSTANCE;
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream()); // запись
            inputStream = new ObjectInputStream(socket.getInputStream()); // чтение
            readMessageProcess = startReadMessageProcess();
            connected = true;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendPrivateMessage(String receiver, String message) throws IOException {
        sendCommand(Command.privateMessageCommand(receiver, message));
    }

    public void sendCommand(Command command) throws IOException {
        try {
            outputStream.writeObject(command);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение на сервер");
            e.printStackTrace();
            throw e;
        }
    }

    private Command readCommand() throws IOException {
        Command command = null;

        try {
            command = (Command) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to read Command class");
            e.printStackTrace();
        }

        return command;
    }

    public void sendMessage(String message) throws IOException {
        sendCommand(Command.publicMessageCommand(message));
    }

    public void sendAuthMessage(String login, String password) throws IOException {
        sendCommand(Command.authCommand(login, password));
    }

    public Thread startReadMessageProcess() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            return;
                        }

                        Command command = readCommand();

                        for (ReadMessageListener listener : listeners) {
                            listener.processReceivedCommand(command);
                        }

                    } catch (IOException e) {
                        System.err.println("Не удалось получить сообщение от сервера");
                        e.printStackTrace();
                        close();
                        break;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

    public ReadMessageListener addReadMessageListener(ReadMessageListener listener) {
        this.listeners.add(listener);
        return listener;
    }

    public void removeReadMessageListener(ReadMessageListener listener) {
        this.listeners.remove(listener);
    }

    public void close() {
        try {
            connected = false;
            socket.close();
            readMessageProcess.interrupt();
        } catch (IOException e) {
            System.err.println("Не удалось закрыть сетевое соединение");
        }
    }

    public boolean isConnected() {
        return connected;
    }
}

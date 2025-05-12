package ru.otus.java.basic.homeworks.homework_22.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private int port;
    private Map<String, ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;

    public Server(int port) {
        this.port = port;
        clients = new ConcurrentHashMap<>();
        authenticatedProvider = new InMemoryAuthenticatedProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.put(clientHandler.getUsername(), clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        broadcastMessage("Клиент " + clientHandler.getUsername() + " вышел из чата");
        System.out.println("Клиент " + clientHandler.getUsername() + " вышел из чата");
        clients.remove(clientHandler.getUsername());
    }

    public void broadcastMessage(String message) {
        for (ClientHandler c : clients.values()) {
            c.sendMsg(message);
        }
    }

    public boolean privateMessage(String clientName, String message) {
        if(clients.containsKey(clientName)) {
            clients.get(clientName).sendMsg(message);
            return true;
        }
        return false;
    }

    public boolean isUsernameBusy(String username) {
        return clients.containsKey(username);
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }

}

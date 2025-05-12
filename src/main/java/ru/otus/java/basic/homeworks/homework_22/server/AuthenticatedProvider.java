package ru.otus.java.basic.homeworks.homework_22.server;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    boolean registration(ClientHandler clientHandler, String login, String password, String username);
}

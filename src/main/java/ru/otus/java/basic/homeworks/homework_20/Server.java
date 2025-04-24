package ru.otus.java.basic.homeworks.homework_20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8091);
        System.out.println("SERVER APP STARTED!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом " + client.getPort() + " подключился к серверу");
            String userInput = inputStream.readUTF();
            System.out.println(userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Клиента с портом " + client.getPort() + " отключили от сервера");
                client.close();
                continue;
            }
            String result = Calculator.calc(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
        }
    }
}

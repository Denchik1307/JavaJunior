package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(666)) {
            System.out.println("Сервер запущен, ожидает подключения...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Получено от клиента: " + clientMessage);
                    out.println("От сервера: " + clientMessage.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


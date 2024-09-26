package simple_client_server_app.server;

import simple_client_server_app.log.MyLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

public class ChatServer {
    private static final int PORT = 12222;
    private static final HashMap<String, PrintWriter> listClients = new HashMap<>();


    public static void main(String[] args) {
        System.out.println("Чат-сервер запущен...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            boolean isConnected = false;
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                name = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                sendToAllClients(name + " connected.");

                synchronized (listClients) {
                    listClients.put(name, out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(name + ": " + message);
                    sendToAllClients(message);
                }
            } catch (IOException e) {
                System.out.println("Ошибка в обработчике клиента: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (listClients) {
                    listClients.remove(name);
                }
            }
        }

        private void sendToAllClients(String message) {
            synchronized (listClients) {
                MyLog.write(name + ": " + message);
                for (String client : listClients.keySet()) {
                    if (!client.equals(name)){
                        listClients.get(client).println(name + ": " + message);
                    }
                }
            }
        }
    }
}


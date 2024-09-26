package simple_client_server_app.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {
    private static final int PORT = 12345;
    private static final HashSet<PrintWriter> listClients = new HashSet<>();

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
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (listClients) {
                    listClients.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Получено сообщение: " + message);
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
                    listClients.remove(out);
                }
            }
        }

        private void sendToAllClients(String message) {
            synchronized (listClients) {
                for (PrintWriter client : listClients) {
                    client.println(message);
                }
            }
        }
    }
}


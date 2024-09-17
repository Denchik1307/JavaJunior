package homework_five.server.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket);
                Thread thread = new Thread(clientManager);
                thread.start();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}


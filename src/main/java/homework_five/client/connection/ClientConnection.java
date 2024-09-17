package homework_five.client.connection;

import java.net.Socket;

public class ClientConnection {
    private static Socket socket;
    private final String ip;
    private final int port;

    public ClientConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}

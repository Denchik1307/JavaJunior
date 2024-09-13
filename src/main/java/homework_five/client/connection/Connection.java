package homework_five.client.connection;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    private static Socket socket;
    private final String login;
    private final String password;
    private final int port;
    private final String IP;

    public Connection(String login, String password, String ip, int port) {
        this.login = login;
        this.password = password;
        IP = ip;
        this.port = port;
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
            disconnect();
        }
    }

    public static Socket getSocket() {
        return socket;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getIP() {
        return IP;
    }

    public boolean isConnected() {
        return socket.isConnected();
    }

    public boolean disconnect() {
        return socket.isConnected();
    }
}

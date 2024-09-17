package homework_five.server.connection;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientManager implements Runnable {

    private static ArrayList<ClientManager> clientManagers = new ArrayList<>();
    private final Socket socket;

    public ClientManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}

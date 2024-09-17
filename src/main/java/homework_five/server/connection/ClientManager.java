package homework_five.server.connection;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientManager implements Runnable {

    public static ArrayList<ClientManager> socketsClients = new ArrayList<>();
    private final Socket socket;
    private String name;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public ClientManager(Socket socket) {
        this.socket = socket;
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            bufferedReader = buffReader;
            bufferedWriter = buffWriter;
            name = bufferedReader.readLine();
            socketsClients.add(this);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void close(){
        try {
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

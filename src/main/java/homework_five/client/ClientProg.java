package homework_five.client;

import homework_five.client.view.Window;

import java.io.IOException;
import java.net.Socket;

public class ClientProg {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",666)){
            System.out.println(socket.getPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

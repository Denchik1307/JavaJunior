package homework_five.server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProg {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Timer Example");
        JButton button = new JButton("Click Me");
        final boolean[] state = {false};

        Timer timer = new Timer(1000, new ActionListener() {
            int count = 0; // Count of how many times the timer has ticked

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                System.out.println("Timer ticked " + count + " times.");
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                } else {
                    timer.start();
                }
                System.out.println(timer.isRunning() ? "start" : "stop");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);

//         try (ServerSocket serverSocket = new ServerSocket(666)) {
//            System.out.println("Server on port" + serverSocket.getLocalPort());
//            Socket socket = serverSocket.accept();
//            System.out.println(socket.getLocalPort());
//            while (true){
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}

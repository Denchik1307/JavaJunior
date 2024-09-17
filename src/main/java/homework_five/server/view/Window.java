package homework_five.server.view;

import homework_five.server.connection.Server;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 300;
    Server server;


    public Window() {
        server  = new Server(666);
        setupWindow();
        createPanel();
    }

    private void setupWindow() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("server");
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    }

    private void createPanel() {
        JTextArea text;
        JButton btStartServer = btStart();
        JButton btStopServer = btStop();
        JPanel btPanel = new JPanel(new GridLayout(1, 2));
        btPanel.add(btStartServer);
        btPanel.add(btStopServer);
        add(text = new JTextArea(), BorderLayout.NORTH);
        add(btPanel, BorderLayout.SOUTH);
    }

    private JButton btStart(){
        JButton btStartServer = new JButton("Start server");
        btStartServer.addActionListener(e -> server.run());
        return btStartServer;
    }

    private JButton btStop(){
        JButton btStartServer = new JButton("Stop server");
        btStartServer.addActionListener(e -> server.stop());
        return btStartServer;
    }

}

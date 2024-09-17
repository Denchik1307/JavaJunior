package homework_five.client.view;

import homework_five.client.connection.ClientConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Arrays;


public class Window extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 300;
    private JPanel headPanel;
    private ClientConnection clientConnection;

    public Window() {
        settingWindow();
        createPanel();
        setVisible(true);
    }

    private void settingWindow() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    }


    private Component createHeaderPanel() {
        headPanel = new JPanel(new GridLayout(2, 4));
        JTextField textFieldLogin = new JTextField("User");
        JTextField tfIPAddress = new JTextField("localhost");
        JTextField tfPort = new JTextField("666");
        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(event -> {
            System.out.println("login");
//            clientConnection = new ClientConnection(textFieldLogin.getText(),
//                    tfIPAddress.getText(),
//                    Integer.parseInt(tfPort.getText()));
//            headPanel.setVisible(!clientConnection.isConnected());
        });
        headPanel.add(new JLabel("Host"));
        headPanel.add(new JLabel("Port"));
        headPanel.add(new JLabel("Name"));
        headPanel.add(new JLabel("connect"));
        headPanel.add(tfIPAddress);
        headPanel.add(tfPort);
        headPanel.add(textFieldLogin);
        headPanel.add(btnLogin);
        return headPanel;
    }


    private Component createLog() {
        JTextArea log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField textFieldMessage = new JTextField();
        textFieldMessage.addKeyListener(new SendKeyAdapter());
        JButton btnSend = new JButton("send");
        btnSend.addActionListener(e -> System.out.println("send"));
        panel.add(textFieldMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent event) {
        super.processWindowEvent(event);
        if (event.getID() == WindowEvent.WINDOW_CLOSING) {
//            disconnectServer();
        }
    }

    private static class SendKeyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent event) {
//            if (event.getKeyChar() == '\n' && ClientConnection.getSocket().isConnected()) {
//                message();
//            }
        }
    }
}

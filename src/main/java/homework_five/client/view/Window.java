package homework_five.client.view;

import homework_five.client.connection.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;


public class Window extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 300;
    private JPanel headPanel;
    private Connection connection;


    public Window() {
        setting();
        createPanel();
        setVisible(true);
    }

    private void setting() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }


    public void disconnectServer() {
    }

    public void hideHeaderPanel(boolean isVisible) {
        headPanel.setVisible(isVisible);
    }

    public void login() {
    }

    private void message() {
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    }

    private Component createHeaderPanel() {
        headPanel = new JPanel(new GridLayout(2, 3));
        JTextField textFieldLogin = new JTextField("User");
        JPasswordField password = new JPasswordField("666555333");
        JTextField tfIPAddress = new JTextField("127.0.0.1");
        JTextField tfPort = new JTextField("6655");
        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(e -> {
            System.out.println("login");
            try {
                connection = new Connection(textFieldLogin.getText(), password.getPassword().toString(), tfIPAddress.getText(), Integer.getInteger(tfPort.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        headPanel.add(tfIPAddress);
        headPanel.add(tfPort);
        headPanel.add(new JPanel());
        headPanel.add(textFieldLogin);
        headPanel.add(password);
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
            disconnectServer();
        }
    }

    private class SendKeyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent event) {
            if (event.getKeyChar() == '\n' && Connection.getSocket().isConnected()) {
                message();
            }
        }
    }
}

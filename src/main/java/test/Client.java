package test;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static PrintWriter out;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextField textField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        JButton connectButton = new JButton("Подрубить связь");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        sendButton.addActionListener(e -> {
            String message = textField.getText();
            out.println(message);
            textArea.append("Вы: " + message + "\n");
            textField.setText("");
        });





        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(sendButton, BorderLayout.SOUTH);
        frame.add(connectButton, BorderLayout.SOUTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);

        connectButton.addActionListener(e -> {
        try {
            socket = new Socket("localhost", 666);
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage;
connectButton.setVisible(false);
//            while ((serverMessage = in.readLine()) != null) {
//                textArea.append("Сервер: " + serverMessage + "\n");
//            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        });
    }
}

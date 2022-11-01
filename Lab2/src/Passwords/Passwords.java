package Passwords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passwords extends JFrame {

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel JPanel1;
    private JLabel logLabel;

    private String username = "login", password = "haslo";

    public Passwords() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textField1.getText();
                String psswd = new String(passwordField1.getPassword());

                if (login.equals(username) && psswd.equals(password)) logLabel.setText("Zalogowano");
                else logLabel.setText("Błedny login lub hasło");

                //logLabel.setText("login: " + login + ", password: " + psswd);
            }
        });
    }

    public static void main(String args[]) {
        Passwords dupa = new Passwords();
    }
}

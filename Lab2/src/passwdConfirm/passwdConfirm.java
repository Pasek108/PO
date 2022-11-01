package passwdConfirm;

import checkBox.checkBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passwdConfirm extends JFrame {

    private JPanel JPanel1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;

    private String password = "okon";

    public passwdConfirm() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password1 = new String(passwordField1.getPassword());
                String password2 = new String(passwordField2.getPassword());

                if (!password1.equals(password2)) JOptionPane.showMessageDialog(null, "Passwords do nor match!");
                else if (!password1.equals(password)) JOptionPane.showMessageDialog(null, "Wrong password!");
                else JOptionPane.showMessageDialog(null, "Congratulations you entered correct password!");
            }
        });
    }

    public static void main(String args[]) {
        passwdConfirm dupa = new passwdConfirm();
    }
}

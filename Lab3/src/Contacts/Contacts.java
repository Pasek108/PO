package Contacts;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Contacts extends JFrame {
    private JPanel JPanel1;
    private JList list1;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField birthdateField;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JLabel ageLabel;

    DefaultListModel list_model = new DefaultListModel();
    Object[][] users = {
            {"Jan Kowalski", "jkowalski@mail.com", "782 618 598", "adres", "22-07-1973"},
            {"Marian Nowak", "mnowaki@mail.com", "618 597 828", "adres", "01-01-1980"},
            {"Julia Urban", "jurban@mail.com", "772 608 030", "adres", "27-04-2002"},
            {"Ewelina Nowak-Maciąg", "enowak@mail.com", "543 107 348", "adres", "02-11-1997"}
    };
    int last_index = -1;

    Contacts() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 800, 600);
        this.setVisible(true);

        for (int i = 0; i < users.length; i++) this.list_model.addElement(users[i][0]);
        list1.setModel(list_model);

        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] new_users = new Object[users.length + 1][5];

                for (int i = 0; i < users.length; i++) {
                    for (int j = 0; j < 5; j++) new_users[i][j] = users[i][j];
                }

                new_users[users.length][0] = nameField.getText();
                new_users[users.length][1] = emailField.getText();
                new_users[users.length][2] = phoneField.getText();
                new_users[users.length][3] = addressField.getText();
                new_users[users.length][4] = birthdateField.getText();

                list_model.addElement(new_users[users.length][0]);
                list1.setModel(list_model);

                users = new_users;

                saveExistingButton.setEnabled(false);
            }
        });

        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users[last_index][0] = nameField.getText();
                users[last_index][1] = emailField.getText();
                users[last_index][2] = phoneField.getText();
                users[last_index][3] = addressField.getText();
                users[last_index][4] = birthdateField.getText();

                list_model = new DefaultListModel();
                for (int i = 0; i < users.length; i++) list_model.addElement(users[i][0]);
                list1.setModel(list_model);

                saveExistingButton.setEnabled(false);
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                JList list = (JList) e.getSource();
                last_index = list.locationToIndex(e.getPoint());

                nameField.setText("" + users[last_index][0]);
                emailField.setText("" + users[last_index][1]);
                phoneField.setText("" + users[last_index][2]);
                addressField.setText("" + users[last_index][3]);
                birthdateField.setText("" + users[last_index][4]);

                String date = birthdateField.getText();
                int year = Integer.parseInt(date.split("-")[2]);
                int now_year = new Date().getYear();
                ageLabel.setText("" + (now_year - year + 1900));

                saveExistingButton.setEnabled(true);
            }
        });

        birthdateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (birthdateField.getText().length() < 10) return;

                String date = birthdateField.getText();
                int year = Integer.parseInt(date.split("-")[2]);
                int now_year = new Date().getYear();
                ageLabel.setText("" + (now_year - year + 1900));
            }
        });
    }

    public static void main(String args[]) {
        Contacts aaa = new Contacts();
    }
}

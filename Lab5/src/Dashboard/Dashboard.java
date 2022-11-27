package Dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends JFrame {
    private JPanel JPanel1;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton deleteButton;
    private JTable table1;
    private JButton addButton;
    private JButton clearButton;

    ArrayList<Object[]> clients = new ArrayList<Object[]>();
    String[] coulmn_names = {"Name", "Email", "Phone", "Address"};
    DefaultTableModel table_model = new DefaultTableModel(coulmn_names, 0);

    public Dashboard() {
        super("Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 800, 500);
        this.setVisible(true);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = table1.getSelectedRow();
                if (id < 0) return;

                clients.remove(table1.getSelectedRow());
                table_model.removeRow(id);
                table1.setModel(table_model);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int error = 0;
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                if (name.length() < 1 || email.length() < 1 || phone.length() < 1 || address.length() < 1) error = 1;
                else if (!name.matches("[A-Za-z\\s]+")) error = 2;
                else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) error = 3;
                else if (!phone.matches("\\d{9}") && !phone.matches("\\d{3}[-\\s]\\d{3}[-\\s]\\d{3}")) error = 4;
                else if (!address.matches("[A-Za-z,\\s]+")) error = 5;


                if (error > 0) {
                    String error_text = "";
                    switch(error) {
                        case 1: error_text = "Puste pole w formularzu"; break;
                        case 2: error_text =  "Błędne imie"; break;
                        case 3: error_text =  "Błędny email"; break;
                        case 4: error_text =  "Błędny numer"; break;
                        case 5: error_text =  "Błędny adres"; break;
                    }

                    JOptionPane.showMessageDialog(null, error_text, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object[] client = {nameField.getText(), emailField.getText(), phoneField.getText(), addressField.getText()};
                clients.add(client);

                table_model.addRow(client);
                table1.setModel(table_model);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");
            }
        });
    }

    static public void main(String[] args) {
        Dashboard aaa = new Dashboard();
    }
}

package Kanban;

import datechooser.beans.DateChooserCombo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddForm extends JFrame{

    private JPanel JPanel1;
    private JTextField titleField;
    private JComboBox comboBox1;
    private JButton addButton;
    private JButton closeButton;
    private DateChooserCombo dateChooser;

    public AddForm() {
        super("Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 800, 500);
        this.setVisible(true);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                int priority = comboBox1.getSelectedIndex();
                Calendar date = dateChooser.getSelectedDate();

                System.out.println(LocalDateTime.now());
                System.out.println(date.getTime());

                Observer.observer.sendDataToSubscriber(title, priority, date);
                dispose();
            }
        });
    }
}

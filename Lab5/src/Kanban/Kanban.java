package Kanban;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Kanban extends JFrame{

    private JPanel JPanel1;
    private JTabbedPane tabbedPane1;
    private JButton addNewTaskButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JTextField informacjeOProgramieTextField;
    private JButton backButton;
    private JButton closeButton;

    private ArrayList<String> to_do = new ArrayList<String>();
    private ArrayList<String> in_progress = new ArrayList<String>();
    private ArrayList<String> done = new ArrayList<String>();

    DefaultListModel to_do_list_model = new DefaultListModel();
    DefaultListModel in_progress_list_model = new DefaultListModel();
    DefaultListModel done_list_model = new DefaultListModel();

    public Kanban() {
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
                System.exit(0);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(0);
            }
        });

        addNewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddForm form = new AddForm();
            }
        });
    }

    public void addTask(String title, int priority, Calendar date) {
        to_do.add(title);
        to_do_list_model.addElement(title);
        list1.setModel(to_do_list_model);
    }

    static public void main(String[] args) {
        Kanban aaa = new Kanban();
        Observer.observer.addSubscriber(aaa);
    }
}

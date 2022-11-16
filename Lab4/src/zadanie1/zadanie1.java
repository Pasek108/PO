package zadanie1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class zadanie1 extends JFrame {
    private JPanel JPanel1;
    private JButton button1;
    private JButton button4;
    private JButton button3;
    private JButton button2;
    private JList list2;
    private JList list1;

    private DefaultListModel list1_model = new DefaultListModel();
    private ArrayList<String> list1_elements = new ArrayList<String>(Arrays.asList("element1", "element2", "element3", "element4", "element5", "element6", "element7"));

    private DefaultListModel list2_model = new DefaultListModel();
    private ArrayList<String> list2_elements = new ArrayList<String>(Arrays.asList("element1", "element2", "element3"));

    public zadanie1() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        for (int i = 0; i < list1_elements.size(); i++) list1_model.addElement(list1_elements.get(i));
        list1.setModel(list1_model);

        for (int i = 0; i < list2_elements.size(); i++) list2_model.addElement(list2_elements.get(i));
        list2.setModel(list2_model);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = list1.getSelectedIndex();
                if (id < 0) return;

                list2_model.addElement(list1_elements.get(id));
                list1_model.removeElement(list1_elements.get(id));

                list2_elements.add(list1_elements.get(id));
                list1_elements.remove(list1_elements.get(id));

                list1.setModel(list1_model);
                list2.setModel(list2_model);
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (list1_elements.size() > 0) {
                    list2_model.addElement(list1_elements.get(0));
                    list2_elements.add(list1_elements.get(0));
                    list1_elements.remove(list1_elements.get(0));
                }

                list2.setModel(list2_model);
                list1_model.removeAllElements();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = list2.getSelectedIndex();
                if (id < 0) return;

                list1_model.addElement(list2_elements.get(id));
                list2_model.removeElement(list2_elements.get(id));

                list1_elements.add(list2_elements.get(id));
                list2_elements.remove(list2_elements.get(id));

                list1.setModel(list1_model);
                list2.setModel(list2_model);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (list2_elements.size() > 0) {
                    list1_model.addElement(list2_elements.get(0));
                    list1_elements.add(list2_elements.get(0));
                    list2_elements.remove(list2_elements.get(0));
                }

                list1.setModel(list1_model);
                list2_model.removeAllElements();
            }
        });
    }

    public static void main(String[] args) {
        zadanie1 aaa = new zadanie1();
    }
}

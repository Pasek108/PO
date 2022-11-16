package JTreeExample;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTreeExample extends JFrame {
    private JPanel JPanel1;
    private JTextField kursInput;
    private JTextField cenaInput;
    private JButton wyjścieButton;
    private JButton opłaćKursButton;
    private JTree tree1;

    public JTreeExample() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        tree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (tree1.getSelectionPath() == null) return;
                DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree1.getSelectionPath().getLastPathComponent();

                String select = root.getUserObject().toString();
                kursInput.setText(select);

                switch(select) {
                    case "C": cenaInput.setText("120"); break;
                    case "C#": cenaInput.setText("220"); break;
                    case "C++": cenaInput.setText("320"); break;
                    case "Java": cenaInput.setText("420"); break;
                    case "Python": cenaInput.setText("520"); break;
                    case "ASP.NET": cenaInput.setText("620"); break;
                    case "Photoshop": cenaInput.setText("720"); break;
                    case "Corel": cenaInput.setText("820"); break;
                    case "AutoCad": cenaInput.setText("920"); break;
                    case "InDesign": cenaInput.setText("1020"); break;
                }
            }
        });

        opłaćKursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = "";
                JOptionPane.showInputDialog(null, imie);
            }
        });

        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjść?", "Wyjście", JOptionPane.YES_NO_OPTION);

                if (option == 0) {
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        JTreeExample aaa = new JTreeExample();
    }

    private void createUIComponents() {
        // root
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Moje kursy");

        // poziom 1
        DefaultMutableTreeNode Kprog = new DefaultMutableTreeNode("Programowanie");
        String[] prog_options = {"C", "C#", "C++", "Java", "Python", "ASP.NET"};

        for (int i = 0; i < prog_options.length; i++) {
            DefaultMutableTreeNode prog = new DefaultMutableTreeNode(prog_options[i]);
            Kprog.add(prog);
        }

        // poziom 2
        DefaultMutableTreeNode Kgrafika = new DefaultMutableTreeNode("Grafika komputerowa");
        String[] grafika_options = {"Photoshop", "Corel", "AutoCad", "InDesign"};

        for (int i = 0; i < grafika_options.length; i++) {
            DefaultMutableTreeNode grafika = new DefaultMutableTreeNode(grafika_options[i]);
            Kgrafika.add(grafika);
        }

        root.add(Kprog);
        root.add(Kgrafika);

        DefaultTreeModel model = new DefaultTreeModel(root);
        tree1 = new JTree(model);
        //tree1.setModel(model);
    }
}

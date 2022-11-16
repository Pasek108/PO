package JListExapmle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JListExapmle extends JFrame {

    private JPanel JPanel1;

    JListExapmle() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 800 ,600);
        this.setVisible(true);


    }

    public static void main(String args[]) {
        JListExapmle aaa = new JListExapmle();
    }
}

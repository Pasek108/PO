package ShowText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowText extends JFrame {
    private JPanel JPanel1;
    private JComboBox comboBox1;
    private JButton showButton;
    private JLabel text;

    ShowText() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500 ,500);
        this.setVisible(true);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"You selected: " + comboBox1.getSelectedItem());
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("You selected: " + comboBox1.getSelectedItem());
            }
        });
    }

    public static void main(String args[]) {
        ShowText aaa = new ShowText();
    }
}

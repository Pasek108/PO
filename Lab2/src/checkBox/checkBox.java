package checkBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkBox extends JFrame {
    private JPanel JPanel1;
    private JCheckBox javaPrice3500plnCheckBox;
    private JCheckBox cPrice4000plnCheckBox;
    private JCheckBox pythonPrice5000plnCheckBox;
    private JCheckBox cPrice3000plnCheckBox;
    private JButton okButton;

    public checkBox() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "";

                if (javaPrice3500plnCheckBox.isSelected()) text += javaPrice3500plnCheckBox.getText() + "\n";
                else text += "------------------------\n";

                if (cPrice4000plnCheckBox.isSelected()) text += cPrice4000plnCheckBox.getText() + "\n";
                else text += "------------------------\n";

                if (cPrice3000plnCheckBox.isSelected()) text += cPrice3000plnCheckBox.getText() + "\n";
                else text += "------------------------\n";

                if (pythonPrice5000plnCheckBox.isSelected()) text += pythonPrice5000plnCheckBox.getText() + "\n";
                else text += "------------------------\n";

                JOptionPane.showMessageDialog(null, text);
            }
        });
    }

    public static void main(String args[]) {
        checkBox dupa = new checkBox();
    }
}

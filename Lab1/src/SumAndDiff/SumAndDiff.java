package SumAndDiff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumAndDiff extends JFrame {
    private JPanel JPanel1;
    private JButton sumaButton;
    private JButton różnicaButton;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JLabel wynikLabel;

    public SumAndDiff() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500 ,500);
        this.setVisible(true);

        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double a = Double.parseDouble(textFieldA.getText());
                Double b = Double.parseDouble(textFieldB.getText());
                Double wynik = a + b;
                wynikLabel.setText("" + wynik);
            }
        });


        różnicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double a = Double.parseDouble(textFieldA.getText());
                Double b = Double.parseDouble(textFieldB.getText());
                Double wynik = a - b;
                wynikLabel.setText("" + wynik);
            }
        });
    }

    public static void main(String[] args) {
        SumAndDiff obiekt = new SumAndDiff();
    }
}

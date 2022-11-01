package TemperatureConvert;

import SumAndDiff.SumAndDiff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConvert extends JFrame {
    private JPanel JPanel1;
    private JTextField textFieldC;
    private JTextField textFieldF;

    public TemperatureConvert() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500 ,500);
        this.setVisible(true);


        textFieldC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double c = Double.parseDouble(textFieldC.getText());
                Double f =  (c * 9/5) + 32;
                textFieldF.setText("" + f);
            }
        });


        textFieldF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double f = Double.parseDouble(textFieldC.getText());
                Double c =  (f - 32) * 5/9;
                textFieldC.setText("" + c);
            }
        });
    }

    public static void main(String[] args) {
        TemperatureConvert obiekt = new TemperatureConvert();
    }
}

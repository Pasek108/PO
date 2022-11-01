import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Date extends JFrame {
    private JPanel JPanel1;
    private JButton displayDateButton;
    private JButton closeButton;
    private JLabel dateLabel;

    public Date() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500 ,500);
        this.setVisible(true);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        displayDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = new java.util.Date().toString();
                dateLabel.setText(date);
            }
        });
    }

    public static void main(String[] args) {
        Date obiekt = new Date();
    }
}

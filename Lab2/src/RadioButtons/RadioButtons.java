package RadioButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtons extends JFrame  {

    private JPanel JPanel1;
    private JRadioButton windowsRadioButton;
    private JRadioButton linuxRadioButton;
    private JRadioButton macRadioButton;
    private JButton zatwierdźButton;
    private JPanel imagePanel;

    private String system = "windows";
/*
    private ImageIcon iconWindows = new ImageIcon("windows.png");
    private ImageIcon iconLinux = new ImageIcon("linux.png");
    private ImageIcon iconMac = new ImageIcon("mac.png");
*/
    public ImageIcon SetImageSize(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        return newImc;
    }

    public RadioButtons() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowsRadioButton.isSelected()) {
                    imagePanel.add(new JLabel(SetImageSize("windows.png")));
                    system = "windows";
                }
                else if (linuxRadioButton.isSelected()) {
                    imagePanel.add(new JLabel(SetImageSize("linux.png")));
                    system = "linux";
                }
                else {
                    imagePanel.add(new JLabel(SetImageSize("mac.png")));
                    system = "mac";
                }
            }
        };
        windowsRadioButton.addActionListener(listener);
        linuxRadioButton.addActionListener(listener);
        macRadioButton.addActionListener(listener);

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String args[]) {
        RadioButtons dupa = new RadioButtons();
    }
}

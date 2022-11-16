package zadanie2;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class zadanie2 extends JFrame {
    private JPanel JPanel1;
    private JComboBox comboBox1;
    private JEditorPane editorPane1;
    private JButton bButton;
    private JButton zButton;
    private JButton iButton;
    private JButton pButton;

    private int font_size = 12;
    private int style = Font.PLAIN;
    private Boolean is_bold = false;
    private Boolean is_italic = false;

    public zadanie2() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                is_bold = !is_bold;
                style = Font.PLAIN;

                if (is_bold) style = style | Font.BOLD;
                if (is_italic) style = style | Font.ITALIC;

                editorPane1.setFont(new Font("Dialog", style, font_size));
            }
        });

        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                is_italic = !is_italic;
                style = Font.PLAIN;

                if (is_bold) style = style | Font.BOLD;
                if (is_italic) style = style | Font.ITALIC;
                editorPane1.setFont(new Font("Dialog", style, font_size));
            }
        });

        zButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_size++;
                editorPane1.setFont(new Font("Dialog", style, font_size));
            }
        });

        pButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_size--;
                editorPane1.setFont(new Font("Dialog", style, font_size));
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = comboBox1.getSelectedIndex();

                switch (id) {
                    case 0: editorPane1.setForeground(Color.black); break;
                    case 1: editorPane1.setForeground(Color.red); break;
                    case 2: editorPane1.setForeground(Color.green); break;
                    case 3: editorPane1.setForeground(Color.blue); break;
                    case 4: editorPane1.setForeground(Color.yellow); break;
                    case 5: editorPane1.setForeground(Color.gray); break;
                    case 6: editorPane1.setForeground(Color.magenta); break;
                }
            }
        });
    }

    public static void main(String[] args) {
        zadanie2 aaa = new zadanie2();
    }
}

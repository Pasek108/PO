package PopularShows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PopularShows extends JFrame {
    private JPanel JPanel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton episodeRatingsButton;
    private JButton IMDBPageButton;
    private JTextField textField1;
    private JTable table1;

    private String[] columnNames = {"Title", "Year", "Rating", "Num Votes"};
    private Object[][] rows = {
            {"Top Gun: Maverick", 2022, 8.13, 50977},
            {"Everything Everywhere All At Once 2022", 2022, 8.53, 16746},
            {"Batman", 2022, 7.41, 87181}
    };

    PopularShows() {
        super("łutyt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 800 ,600);
        this.setVisible(true);

        table1.setModel(new DefaultTableModel(this.rows, this.columnNames));
    }

    public static void main(String args[]) {
        PopularShows aaa = new PopularShows();
    }
}

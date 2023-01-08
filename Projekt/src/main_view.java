import com.mysql.cj.jdbc.DatabaseMetaData;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class main_view extends JFrame {
    private JPanel JPanel1;
    private JButton addNewDatabaseButton;
    private JTree tree1;
    private JButton deleteButton;
    private JTable table1;
    private JButton deleteButton1;
    private JButton editButton;
    private JButton showRelationsButton;
    private JButton importExportButton;
    private JButton addButton;

    public main_view() {
        super("Poor Database Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(JPanel1);
        this.pack();
        this.setBounds(100, 100, 1024, 600);
        this.setVisible(true);
        tree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (tree1.getSelectionPath() == null) return;
                DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree1.getSelectionPath().getLastPathComponent();

                String selected_node = root.getUserObject().toString();
                System.out.println(selected_node);
                System.out.println(root.getParent());

                if (!root.getParent().equals("Database") && !selected_node.equals("empty")) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
                        Statement st = con.createStatement();
                        st.executeUpdate("use " + root.getParent() + ";");
                        String a = "select * from " + selected_node;
                        ResultSet rs = st.executeQuery(a);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnsNumber = rsmd.getColumnCount();

                        for(int i = 1; i <= columnsNumber; i++) System.out.print(rsmd.getColumnLabel(i) + " ");
                        System.out.println();

                        while (rs.next()) {
                            for(int i = 1; i <= columnsNumber; i++) System.out.print(rs.getString(i) + " ");
                            System.out.println();
                        }
                    }
                    catch(Exception err) {
                        err.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new main_view();
    }

    private void createUIComponents() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String mysqlUrl = "jdbc:mysql://localhost";
            conn = DriverManager.getConnection(mysqlUrl, "root", "");

            Statement stmt = conn.createStatement();
            ResultSet databases = stmt.executeQuery("Show Databases");

            DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
            ResultSet tables = meta.getTables(null, null, null, new String[] {"TABLE"});

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Databases");

            while(databases.next()) {
                String db_name = databases.getString(1);
                ArrayList<String> tables_names = new ArrayList<String>();
                tables.first();

                while (tables.next()) {
                    if (tables.getString("TABLE_CAT").equals(db_name)) {
                        String table_name = tables.getString("TABLE_NAME");
                        tables_names.add(table_name);
                    }
                }

                root.add(createTableInfo(db_name, tables_names));
            }

            DefaultTreeModel model = new DefaultTreeModel(root);
            tree1 = new JTree(model);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DefaultMutableTreeNode createTableInfo(String db_name, ArrayList<String> tables_names) {
        DefaultMutableTreeNode database = new DefaultMutableTreeNode(db_name);

        for (int i = 0; i < tables_names.size(); i++) {
            DefaultMutableTreeNode table = new DefaultMutableTreeNode(tables_names.get(i));
            database.add(table);
        }

        if (tables_names.size() == 0) database.add(new DefaultMutableTreeNode("empty"));

        return database;
    }
}

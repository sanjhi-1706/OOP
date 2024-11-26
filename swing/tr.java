package swing;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class tr extends JFrame {
    
    // Declare JTable
    private JTable table;
    private JScrollPane scrollPane;
    
    public tr() {
        // Set frame title and properties
        setTitle("Employee Data");
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Call method to create the JTable
        createTable();
    }
    
    // Method to create the JTable and fetch data from database
    private void createTable() {
        // Column names for the JTable
        String[] columnNames = {"ID", "Name", "Department", "Salary"};
        
        // Create a DefaultTableModel with column names and no initial data
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        
        // Create a JTable with the model
        table = new JTable(model);
        
        // Add scrollpane to the JTable
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Connect to the database and fetch data
        fetchDataFromDatabase(model);
    }

    // Method to fetch data from database and populate the JTable
    private void fetchDataFromDatabase(DefaultTableModel model) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "12345@abcde";
        
        try {
            // Create a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create a SQL query to fetch data from the table
            String query = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            // Fetch the data row by row
            while (rs.next()) {
                // Retrieve values from the result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                
                // Add the row to the JTable model
                model.addRow(new Object[] {id, name, department, salary});
            }
            
            // Close the ResultSet and Connection
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> {
            new tr().setVisible(true);
        });
    }
}

package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementSystem {
    private JFrame frame;
    private JTextField studentIdField, nameField, ageField, genderField, departmentField;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Connection conn;

    public StudentManagementSystem() {
        // Initialize the GUI
        frame = new JFrame("Student Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Connect to the database
        connectToDatabase();

        // Create form panel for input fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        studentIdField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();
        departmentField = new JTextField();

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(studentIdField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(genderField);
        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentField);

        // Create Buttons Panel for actions (Add, Update, Delete, View)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton viewButton = new JButton("View");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        // JTable to display students
        String[] columnNames = {"Student ID", "Name", "Age", "Gender", "Department"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Add components to the frame
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Connect to the MySQL database
    private void connectToDatabase() {
        try {
            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root"; // MySQL username
            String password = "12345@abcde"; // MySQL password

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to add a student to the database
    private void addStudent() {
        try {
            String query = "INSERT INTO students (student_id, name, age, gender, department) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(studentIdField.getText()));
            stmt.setString(2, nameField.getText());
            stmt.setInt(3, Integer.parseInt(ageField.getText()));
            stmt.setString(4, genderField.getText());
            stmt.setString(5, departmentField.getText());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student Added Successfully!");
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to Add Student!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to update an existing student's record
    private void updateStudent() {
        try {
            String query = "UPDATE students SET name = ?, age = ?, gender = ?, department = ? WHERE student_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nameField.getText());
            stmt.setInt(2, Integer.parseInt(ageField.getText()));
            stmt.setString(3, genderField.getText());
            stmt.setString(4, departmentField.getText());
            stmt.setInt(5, Integer.parseInt(studentIdField.getText()));

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student Updated Successfully!");
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to Update Student!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete a student from the database
    private void deleteStudent() {
        try {
            String query = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(studentIdField.getText()));

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student Deleted Successfully!");
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to Delete Student!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to view all students in the JTable
    private void viewStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            tableModel.setRowCount(0);  // Clear existing rows

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String department = rs.getString("department");

                tableModel.addRow(new Object[]{studentId, name, age, gender, department});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to Retrieve Students!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields after an operation
    private void clearFields() {
        studentIdField.setText("");
        nameField.setText("");
        ageField.setText("");
        genderField.setText("");
        departmentField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystem();
            }
        });
    }
}


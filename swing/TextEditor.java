package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;

public class TextEditor {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel statusBar;
    private String currentFile = "";

    public TextEditor() {
        // Initialize frame
        frame = new JFrame("Basic Text Editor");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JTextArea for writing text
        textArea = new JTextArea();
        textArea.setLineWrap(true);  // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // ScrollPane to add scrolling capability to the JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the status bar
        statusBar = new JLabel("Character count: 0");
        statusBar.setBorder(BorderFactory.createBevelBorder(1));

        // Add JTextArea and status bar to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);

        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // Menu items
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners to menu items
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearText();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add items to the file menu and menu bar
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        // Add Key Listener to update character count in the status bar
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateStatusBar();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Open a file and display its contents
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open File");
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText(""); // Clear previous content
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                reader.close();
                currentFile = file.getAbsolutePath();
                updateStatusBar();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Save the current text to a file
    private void saveFile() {
        if (currentFile.isEmpty()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save File");
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                currentFile = file.getAbsolutePath();
            } else {
                return;
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
            writer.write(textArea.getText());
            writer.close();
            JOptionPane.showMessageDialog(frame, "File saved successfully!");
            updateStatusBar();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear the text area
    private void clearText() {
        textArea.setText("");
        currentFile = "";
        updateStatusBar();
    }

    // Update the status bar with the character count
    private void updateStatusBar() {
        int charCount = textArea.getText().length();
        int lineCount = textArea.getLineCount();
        statusBar.setText("Lines: " + lineCount + " | Characters: " + charCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditor();
            }
        });
    }
}

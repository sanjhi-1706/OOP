package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q3 {
    private JFrame frame;
    private JTextField display;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;
    
    public q3() {
        frame = new JFrame("Basic Calculator");
        display = new JTextField();
        
        // Setting layout and default configurations
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Setup the display (top of the calculator)
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(display, BorderLayout.NORTH);
        
        // Create the panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout for buttons
        frame.add(panel, BorderLayout.CENTER);
        
        // Create and add buttons to the panel
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            panel.add(button);
            
            // Add ActionListener to buttons
            button.addActionListener(new ButtonClickListener());
        }
        
        // Add a Clear button
        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(clearButton, BorderLayout.SOUTH);
        
        // Add ActionListener to Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentInput = "";
                operator = "";
                firstOperand = 0;
                display.setText("");
            }
        });

        // KeyListener to allow keyboard input
        display.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/' || keyChar == '=' || keyChar == '.') {
                    currentInput += keyChar;
                    display.setText(currentInput);
                } else if (keyChar == KeyEvent.VK_ENTER) {
                    calculate();
                } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
                    if (!currentInput.isEmpty()) {
                        currentInput = currentInput.substring(0, currentInput.length() - 1);
                        display.setText(currentInput);
                    }
                }
            }
        });

        // FocusListener to show when text field is in focus
        display.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                display.setBackground(Color.YELLOW); // Change background color on focus
            }
            public void focusLost(FocusEvent e) {
                display.setBackground(Color.WHITE); // Reset background color when focus is lost
            }
        });
        
        // Set the frame visible
        frame.setVisible(true);
    }

    // ActionListener for all button clicks
    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Handle numbers and operators
            if (command.matches("[0-9]") || command.equals(".")) {
                currentInput += command;
                display.setText(currentInput);
            } else if (command.equals("=")) {
                calculate();
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                // Store the first operand and the operator for later calculation
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                    currentInput = "";
                    operator = command;
                }
            }
        }
    }

    // Perform calculation based on operator and operands
    private void calculate() {
        if (currentInput.isEmpty()) return;

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        currentInput = String.valueOf(result); // For continuous calculations
        operator = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new q3());
    }
}


package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class QuizApp {
    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup optionsGroup;
    private JButton nextButton, finishButton;
    private int score = 0;
    private int currentQuestionIndex = 0;

    // Array to store questions and options
    private String[] questions = {
        "What is the capital of France?",
        "Which programming language is known as the language of the web?",
        "Which animal is known as the king of the jungle?",
        "Who wrote 'To Kill a Mockingbird'?"
    };

    private String[][] options = {
        {"Paris", "London", "Berlin", "Madrid"},
        {"Python", "C++", "JavaScript", "Java"},
        {"Lion", "Elephant", "Tiger", "Bear"},
        {"Harper Lee", "J.K. Rowling", "Jane Austen", "Mark Twain"}
    };

    private int[] correctAnswers = {0, 2, 0, 0}; // Index of correct answers for each question

    public QuizApp() {
        frame = new JFrame("Quiz Application");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel(questions[currentQuestionIndex]);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(questionLabel);

        // Initialize radio buttons
        option1 = new JRadioButton(options[currentQuestionIndex][0]);
        option2 = new JRadioButton(options[currentQuestionIndex][1]);
        option3 = new JRadioButton(options[currentQuestionIndex][2]);
        option4 = new JRadioButton(options[currentQuestionIndex][3]);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        // Add options to panel
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);

        // Add Next button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 15));
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    updateQuestion();
                } else {
                    nextButton.setEnabled(false);
                    finishButton.setEnabled(true);
                }
            }
        });

        panel.add(nextButton);

        // Add Finish button (Initially disabled)
        finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Arial", Font.PLAIN, 15));
        finishButton.setEnabled(false);
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Quiz Finished! Your final score is: " + score + "/" + questions.length);
                System.exit(0);
            }
        });
        panel.add(finishButton);

        // Set frame properties
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to check answer and update score
    private void checkAnswer() {
        if (option1.isSelected() && correctAnswers[currentQuestionIndex] == 0) {
            score++;
        } else if (option2.isSelected() && correctAnswers[currentQuestionIndex] == 1) {
            score++;
        } else if (option3.isSelected() && correctAnswers[currentQuestionIndex] == 2) {
            score++;
        } else if (option4.isSelected() && correctAnswers[currentQuestionIndex] == 3) {
            score++;
        }
    }

    // Method to update question and options
    private void updateQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        option1.setText(options[currentQuestionIndex][0]);
        option2.setText(options[currentQuestionIndex][1]);
        option3.setText(options[currentQuestionIndex][2]);
        option4.setText(options[currentQuestionIndex][3]);

        // Clear selected radio buttons
        optionsGroup.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizApp();
            }
        });
    }
}

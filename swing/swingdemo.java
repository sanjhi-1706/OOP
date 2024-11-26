package swing;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class swingdemo extends JFrame {
    private JLabel timeLabel;
    private Timer timer;

    public swingdemo() {
        // Set up the frame
        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JLabel to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        // Create a timer that updates the time every second
        timer = new Timer(1000, e -> updateTime());
        timer.start();

        // Set the initial time
        updateTime();

        // Make the frame visible
        setVisible(true);
    }

    private void updateTime() {
        // Get the current time and format it
        String timeFormat = "HH:mm:ss"; // 24-hour format
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        String currentTime = sdf.format(new Date());
        
        // Update the JLabel with the current time
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new swingdemo());
    }
}
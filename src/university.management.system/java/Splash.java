import javax.swing.*;
import java.awt.*;

public class Splash {
}
package university.management.system;

import javax.swing.*;
        import java.awt.*;

/**
 * The Splash class creates a splash screen for the University Management System application.
 * It displays an animated window that gradually increases in size and then disappears after a short period,
 * leading to the Login screen.
 */
public class Splash extends JFrame implements Runnable {

    // Thread instance to handle the animation
    Thread t;
    /**
     * Constructor to set up the splash screen.
     * Loads an image, starts the animation thread, and makes the splash screen visible.
     */
    Splash () {
        // Load the splash image and scale it to fit the window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);  // Add the image to the frame

        // Initialize and start the thread for animation

        t = new Thread(this);
        t.start();

        // Make the splash screen visible
        setVisible(true);

        // Animate the window size and location
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));
            setSize(i + 3*x, i + x/2);

            try {
                // Pause the thread for 10 milliseconds to create the animation effect
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);

            // Next Frame
            new Login();
        } catch (Exception e) {

        }
    }
    /**
     * The main method to start the Splash screen.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        new Splash();// Create and display the splash screen
    }
}

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class randomPasswordGenerator{
    public static void main(String[] args) {
        //Create a Java Frame
        JFrame frame = new JFrame("Random Password Generator");
        frame.setSize(350, 400);
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x38B6FF));
        panel.setLayout(null);
        frame .add(panel);

        // Add labels to the panel
        JLabel title =  new JLabel("Random Password Generator");
        title.setFont(new Font("Times New Roman", Font.BOLD, 18));
        title.setBounds(50, 25, 800, 75);
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel passwordLengthLabel = new JLabel("Length: ");
        passwordLengthLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLengthLabel.setForeground(Color.BLACK);
        passwordLengthLabel.setBounds(70, 120, 200, 50);
        panel.add(passwordLengthLabel);

        // Add TextField and PasswordField to the panel
        JTextField passwordLengthTextField = new JTextField();
        passwordLengthTextField.setBounds(145, 130, 122, 22);
        passwordLengthTextField.setBackground(new Color(0x38B6FF));
        passwordLengthTextField.setForeground(Color.BLACK);
        //Add an underline border to the passwordTextField
        Border bottomBorder = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        passwordLengthTextField.setBorder(bottomBorder);
        panel.add(passwordLengthTextField);

        // Add generate Button to the generatePanel
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateButton.setForeground(Color.BLACK);
        generateButton.setBackground(Color.WHITE);
        generateButton.setBounds(40, 180, 250, 25);
        generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateButton.setBorderPainted(false);
        panel.add(generateButton);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(100, 270, 122, 22);
        passwordTextField.setBackground(new Color(0x38B6FF));
        passwordTextField.setForeground(Color.BLACK);
        passwordTextField.setBorder(bottomBorder);

        //Clear Button Function
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the length of the password from the text field
                String lengthString = passwordLengthTextField.getText();
                if (lengthString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the length of the password!", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // exit the method if length is not provided
                }
                
                int length = Integer.parseInt(lengthString);
                
                // Define characters to be used in the password
                String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
                String numbers = "0123456789";
                String specialChars = "!@#$%^&*()-_=+";

                // Create a combined string of all characters
                String allChars = uppercaseLetters + lowercaseLetters + numbers + specialChars;

                // Create a StringBuilder to store the password
                StringBuilder password = new StringBuilder();

                // Create an instance of Random
                Random random = new Random();

                // Generate random characters and append them to the password until the desired length is reached
                for (int i = 0; i < length; i++) {
                    // Generate a random index within the range of the combined characters string
                    int index = random.nextInt(allChars.length());
                    // Append the character at the generated index to the password
                    password.append(allChars.charAt(index));
                }

                // Set the generated password to the password text field
                passwordTextField.setText(password.toString());
                
                // Add the password text field to the panel
                panel.add(passwordTextField);
            }
        });

        //Make the frame visible
        frame.setVisible(true);
    }
}
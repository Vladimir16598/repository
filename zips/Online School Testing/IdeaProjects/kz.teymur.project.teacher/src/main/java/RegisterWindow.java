import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iww on 21.01.2015.
 */

public class RegisterWindow {

    private static JPanel panel;

    private static JTextField nameText;
    private static JTextField surnameText;
    private static JTextField loginText;
    private static JPasswordField passwordField;
    private static JTextField emailText;

    private static JComboBox classesNumberBox;
    private static JComboBox classesLetterBox;

    private static JButton registerButton;
    private static JButton cancelButton;

    private static JButton loginLabelButton;
    private static JButton nameLabelButton;
    private static JButton surnameLabelButton;
    private static JButton passwordLabelButton;
    private static JButton emailLabelButton;

    private static eHandler handler;

    private static Font font;

    private static final String[] CLASSES_NUMBER = {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11"
    };

    private static final String[] CLASSES_LETTER = {
            "A",
            "B",
            "C",
    };

    RegisterWindow(){

        handler = new eHandler();

        font = new Font("Verdana", Font.PLAIN, 15);

        panel = new JPanel();
        panel.setFont(font);

        nameText = new JTextField(20);
        nameText.setFont(font);
        nameText.setToolTipText("Enter your name.");

        surnameText = new JTextField(20);
        surnameText.setFont(font);
        surnameText.setToolTipText("Enter your surname.");

        loginText = new JTextField(20);
        loginText.setFont(font);
        loginText.setToolTipText("Enter your login. It must be unique.");

        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        passwordField.setToolTipText("Enter your password.");

        emailText = new JTextField(20);
        emailText.setFont(font);
        emailText.setToolTipText("Enter your E-MAIL. It must be unique.");

        classesNumberBox = new JComboBox(CLASSES_NUMBER);
        classesNumberBox.setFont(font);
        classesNumberBox.setToolTipText("Choose your class");

        classesLetterBox = new JComboBox(CLASSES_LETTER);
        classesLetterBox.setFont(font);
        classesLetterBox.setToolTipText("Choose your letter");

        registerButton = new JButton("Register");
        registerButton.setFont(font);
        registerButton.setFocusable(false);
        registerButton.addActionListener(handler);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(font);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(handler);

        nameLabelButton = new JButton("Name:");
        nameLabelButton.setFont(font);
        nameLabelButton.setFocusable(false);
        nameLabelButton.setEnabled(false);

        surnameLabelButton = new JButton("Surname:");
        surnameLabelButton.setFont(font);
        surnameLabelButton.setFocusable(false);
        surnameLabelButton.setEnabled(false);

        loginLabelButton = new JButton("Login:");
        loginLabelButton.setFont(font);
        loginLabelButton.setFocusable(false);
        loginLabelButton.setEnabled(false);

        passwordLabelButton = new JButton("Password:");
        passwordLabelButton.setFont(font);
        passwordLabelButton.setFocusable(false);
        passwordLabelButton.setEnabled(false);

        emailLabelButton = new JButton("Email:");
        emailLabelButton.setFont(font);
        emailLabelButton.setFocusable(false);
        emailLabelButton.setEnabled(false);

        panel.setLayout(new GridBagLayout());

        panel.add(nameLabelButton, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(nameText, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(surnameLabelButton, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(surnameText, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(loginLabelButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(loginText, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(passwordLabelButton, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(passwordField, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(emailLabelButton, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(emailText, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classesNumberBox, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classesLetterBox, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(registerButton, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(cancelButton, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
    }

    public static class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cancelButton){
                Main.changeContent(Main.getJPanel());
            }
            if (e.getSource() == registerButton){
                Database.registerNewUser(nameText.getText(), surnameText.getText(), loginText.getText(),
                        passwordField.getText(), emailText.getText(), Integer.parseInt(classesNumberBox.getSelectedItem().toString()),
                        classesLetterBox.getSelectedItem().toString());
            }
        }
    }

    public static void endRegister(){
        Main.changeContent(Main.getJPanel());
        JOptionPane.showMessageDialog(null, "Registration completed successfully!\n" +
                "Now you can enter the program, using the username and password.");
    }

    public static JPanel getJPanel(){
        return panel;
    }
}

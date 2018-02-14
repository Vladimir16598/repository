import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iww on 21.01.2015.
 */

public class Main {

    private static JFrame frame;

    private static JPanel panel;

    private static JTextField loginText;
    private static JPasswordField passwordField;

    private static JButton loginButton;
    private static JButton registerButton;

    private static Font font;

    private static eHandler handler;

    private static JPanel nowPanel;

    private static JButton loginLabelButton;
    private static JButton passwordLabelButton;

    Main(){

        font = new Font("Verdana", Font.PLAIN, 15);

        handler = new eHandler();

        frame = new JFrame("Teacher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setFont(font);

        panel = new JPanel();
        panel.setFont(font);

        loginText = new JTextField(15);
        loginText.setFont(font);
        loginText.setToolTipText("Enter your username here.");

        passwordField = new JPasswordField(15);
        passwordField.setFont(font);
        passwordField.setToolTipText("Enter your password here.");

        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.setFont(font);
        loginButton.addActionListener(handler);

        registerButton = new JButton("Register");
        registerButton.setFocusable(false);
        registerButton.setFont(font);
        registerButton.addActionListener(handler);

        loginLabelButton = new JButton("Login:");
        loginLabelButton.setFont(font);
        loginLabelButton.setFocusable(false);
        loginLabelButton.setEnabled(false);

        passwordLabelButton = new JButton("Password:");
        passwordLabelButton.setFont(font);
        passwordLabelButton.setFocusable(false);
        passwordLabelButton.setEnabled(false);

        panel.setLayout(new GridBagLayout());

        panel.add(loginText, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(passwordField, new GridBagConstraints(0, 1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(loginButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(registerButton, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        nowPanel = panel;

        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static JPanel getJPanel(){
        return panel;
    }

    public static void changeContent(JPanel jPanel){
        frame.remove(nowPanel);
        nowPanel = jPanel;
        frame.add(jPanel);
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }

    public static class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registerButton){
                changeContent(RegisterWindow.getJPanel());
            }
            if (e.getSource() == loginButton){
                Database.loginTheProgram(loginText.getText(), passwordField.getText());
            }
        }
    }

    public static void goToMainMenu(){
        new MainMenu();
        frame.dispose();
    }

    public static void newClasses(){
        new RegisterWindow();
        new MainWindow();
        new ListTests();
        new TestWindow();
        new ResultWindow();
        new StatsWindow();
        new HelpWindow();
        new FeedbackWindow();
        new CreateTestWindow();
        new DoneTest();
    }

    public static void classesAfterLogin(){
        Database.getResults();
        Database.getLisTests();
        Database.getOnlineUsers();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    Database.connectToDatabase();
                    newClasses();
                    new Main();
                    new Thread(new LoopThread()).start();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

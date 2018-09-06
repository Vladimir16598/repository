import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainMenu {

    private static JFrame jframe;

    private static JButton mainWindowButton;
    private static JButton testWindowButton;
    private static JButton resultWindowButton;
    private static JButton statsWindowButton;
    private static JButton helpWindowButton;
    private static JButton feedbackWindowButton;
    private static JButton exitButton;
    private static JButton changeLanguageButton;

    private static JPanel contentPanel;
    private static JPanel buttonPanel;
    private static JPanel profilePanel;
    private static JPanel nowPanel;

    private static Font font;

    private static eHandler eHandler = new eHandler();

    private static JLabel helloLabel;
    private static JLabel name_surnameLabel;
    private static JLabel classTeacherLabel;
    private static JLabel emailLabel;

    public static GlobalLanguage globalLanguage;

    MainMenu() {
        globalLanguage = new GlobalLanguage();

        font = new Font("Verdana", Font.PLAIN, 10);

        jframe = new JFrame("Totally Spies Tester");
        jframe.setLayout(null);
        jframe.setSize(607, 398);
        jframe.setFont(font);

        jframe.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Main.getLoopThread().interrupt();
                Database.closeConnection();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        mainWindowButton = new JButton();
        mainWindowButton.addActionListener(eHandler);
        mainWindowButton.setFont(font);
        mainWindowButton.setFocusable(false);

        testWindowButton = new JButton();
        testWindowButton.addActionListener(eHandler);
        testWindowButton.setFont(font);
        testWindowButton.setFocusable(false);

        resultWindowButton = new JButton();
        resultWindowButton.addActionListener(eHandler);
        resultWindowButton.setFont(font);
        resultWindowButton.setFocusable(false);

        statsWindowButton = new JButton();
        statsWindowButton.addActionListener(eHandler);
        statsWindowButton.setFont(font);
        statsWindowButton.setFocusable(false);

        helpWindowButton = new JButton();
        helpWindowButton.addActionListener(eHandler);
        helpWindowButton.setFont(font);
        helpWindowButton.setFocusable(false);

        feedbackWindowButton = new JButton();
        feedbackWindowButton.addActionListener(eHandler);
        feedbackWindowButton.setFont(font);
        feedbackWindowButton.setFocusable(false);

        exitButton = new JButton();
        exitButton.addActionListener(eHandler);
        exitButton.setFont(font);
        exitButton.setFocusable(false);

        buttonPanel = new JPanel();
        buttonPanel.setSize(150, 270);
        buttonPanel.setLocation(0, 100);
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        buttonPanel.setLayout(new GridLayout(7, 1));

        buttonPanel.add(mainWindowButton);
        buttonPanel.add(testWindowButton);
        buttonPanel.add(resultWindowButton);
        buttonPanel.add(statsWindowButton);
        buttonPanel.add(helpWindowButton);
        buttonPanel.add(feedbackWindowButton);
        buttonPanel.add(exitButton);

        contentPanel = MainWindow.getJPanel();
        contentPanel.setLocation(150, 0);
        contentPanel.setSize(450, 370);
        contentPanel.setBorder(BorderFactory.createEtchedBorder());

        profilePanel = new JPanel();
        profilePanel.setSize(150, 100);
        profilePanel.setLocation(0, 0);
        profilePanel.setBorder(BorderFactory.createEtchedBorder());

        helloLabel = new JLabel("Hello, " + Database.getLogin(), SwingConstants.CENTER);
        helloLabel.setFont(font);

        name_surnameLabel = new JLabel(Database.getName() + " " + Database.getSurname(), SwingConstants.CENTER);
        name_surnameLabel.setFont(font);

        emailLabel = new JLabel(Database.getEmail(), SwingConstants.CENTER);
        emailLabel.setFont(font);

        changeLanguageButton = new JButton();
        changeLanguageButton.setFont(font);
        changeLanguageButton.setFocusable(false);
        changeLanguageButton.addActionListener(eHandler);

        profilePanel.setLayout(new GridLayout(5 ,1));
        profilePanel.add(helloLabel);
        profilePanel.add(name_surnameLabel);
        profilePanel.add(emailLabel);
        profilePanel.add(changeLanguageButton);

        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);

        nowPanel = contentPanel;

        getText();

        jframe.add(profilePanel);
        jframe.add(buttonPanel);
        jframe.add(contentPanel);
    }

    public static void getText(){
        exitButton.setText(globalLanguage.getEXIT_BUTTON());
        mainWindowButton.setText(globalLanguage.getMAIN_WINDOW_BUTTON());
        testWindowButton.setText(globalLanguage.getTEST_WINDOW_BUTTON());
        resultWindowButton.setText(globalLanguage.getRESULT_WINDOW_BUTTON());
        statsWindowButton.setText(globalLanguage.getSTATS_WINDOW_BUTTON());
        helpWindowButton.setText(globalLanguage.getHELP_WINDOW_BUTTON());
        feedbackWindowButton.setText(globalLanguage.getFEEDBACK_WINDOW_BUTTON());
        changeLanguageButton.setText(globalLanguage.getCHANGE_LANGUAGE_BUTTON());

        TestWindow.getText();
        FeedbackWindow.getText();
        ResultWindow.getText();
        MainWindow.getText();
    }

    public static class eHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mainWindowButton){
                changeContent(MainWindow.getJPanel());
            }
            if (e.getSource() == testWindowButton){
                changeContent(TestWindow.getJPanel());
            }
            if (e.getSource() == resultWindowButton){
                changeContent(ResultWindow.getJPanel());
            }
            if (e.getSource() == statsWindowButton){
                changeContent(StatsWindow.getJPanel());
            }
            if (e.getSource() == helpWindowButton){
                changeContent(HelpWindow.getJPanel());
            }
            if (e.getSource() == feedbackWindowButton){
                changeContent(FeedbackWindow.getJPanel());
            }
            if (e.getSource() == exitButton){
                Database.closeConnection();
                System.exit(1);
            }
            if (e.getSource() == changeLanguageButton){
                globalLanguage.changeLanguage();
                getText();
            }
        }
    }

    public static void changeContent(JPanel jPanel){
        jframe.remove(nowPanel);
        nowPanel = jPanel;
        nowPanel.setLocation(150, 0);
        nowPanel.setSize(450, 370);
        nowPanel.setBorder(BorderFactory.createEtchedBorder());
        jframe.add(nowPanel);
        jframe.revalidate();
        jframe.repaint();
    }
}

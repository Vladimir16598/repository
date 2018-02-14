/**
 * Created by iww on 18.01.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.*;

public class TestWindow {

    private static JButton createTestButton;
    private static JButton refreshTableButton;

    private static JPanel jPanel;

    private static Font font;

    private static eHandler handler;

    TestWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        handler = new eHandler();

        jPanel = new JPanel();
        jPanel.setFont(font);

        createTestButton = new JButton();
        createTestButton.setFocusable(false);
        createTestButton.setFont(font);
        createTestButton.addActionListener(handler);

        refreshTableButton = new JButton();
        refreshTableButton.setFocusable(false);
        refreshTableButton.setFont(font);
        refreshTableButton.addActionListener(handler);

        jPanel.setLayout(new BorderLayout());

        jPanel.add(createTestButton, BorderLayout.NORTH);
        jPanel.add(ListTests.getJsp(), BorderLayout.CENTER);
        jPanel.add(refreshTableButton, BorderLayout.SOUTH);

        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createTestButton){
                MainMenu.changeContent(CreateTestWindow.getJPanel());
            }
            if (e.getSource() == refreshTableButton){
                Database.getLisTests();
            }
        }
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

    public static void getText(){
        createTestButton.setText(GlobalLanguage.getTestWindowCreateTestButton());
        refreshTableButton.setText(GlobalLanguage.getTestWindowRefreshTableButton());
    }
}

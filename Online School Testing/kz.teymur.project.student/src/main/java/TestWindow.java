/**
 * Created by iww on 25.01.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestWindow {

    private static JButton refreshTableButton;

    private static JPanel jPanel;

    private static Font font;

    private static eHandler handler;

    TestWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        handler = new eHandler();

        jPanel = new JPanel();
        jPanel.setFont(font);

        refreshTableButton = new JButton();
        refreshTableButton.setFocusable(false);
        refreshTableButton.setFont(font);
        refreshTableButton.addActionListener(handler);

        jPanel.setLayout(new BorderLayout());

        jPanel.add(ListTests.getJsp(), BorderLayout.CENTER);
        jPanel.add(refreshTableButton, BorderLayout.SOUTH);

        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static class eHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == refreshTableButton){
                Database.getLisTests();
            }
        }
    }

    public static void getText(){
        refreshTableButton.setText(MainMenu.globalLanguage.getTEST_REFRESH_BUTTON());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

}

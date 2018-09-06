import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 18.01.2015.
 */
public class LocationWindow {
    private static JPanel jPanel;

    private static JLabel jLabel;

    private static Font font;

    LocationWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);

        jLabel = new JLabel("<html>1. You need to open Test tab.<br>"
                + "2. Specify the percentage rule evaluations.<br>"
                + "3. Press Create button.<br>"
                + "4. Press Add new to create new question.<br>"
                + "5. When you create all the questions press Done.<br>"
                + "6. Go to Stats tab, and give your ip address to students.<br>"
                + "7. When students connect to you, they will get the test.<br>"
                + "8. When they are finished, you will see the results in Results tab.<br>");

        jLabel.setFont(font);

        jPanel.add(jLabel);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }
}
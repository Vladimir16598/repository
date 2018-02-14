import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 25.01.2015.
 */
public class FeedbackWindow {

    private static JPanel jPanel;
    private static JLabel jLabel;

    private static Font font;

    FeedbackWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);

        jLabel = new JLabel();
        jLabel.setFont(font);

        jPanel.add(jLabel);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static void getText(){
        jLabel.setText(MainMenu.globalLanguage.getFEEDBACK_WINDOW());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

}

import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 25.01.2015.
 */
public class MainWindow {
    private static JPanel jPanel;

    private static JLabel jLabel;

    private static Font font;

    MainWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);

        jLabel = new JLabel();
        jPanel.add(jLabel);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static void getText(){
        jLabel.setText(MainMenu.globalLanguage.getMAIN_WINDOW());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }
}

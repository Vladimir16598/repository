import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 18.01.2015.
 */
public class FeedbackWindow {

    private static JPanel jPanel;
    private static JLabel jLabel;

    private static Font font;

    FeedbackWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);

        jLabel = new JLabel("<html><p>If you have any suggestions you can send your ideas to <br><center>teymur@live.ru</center></p></html>");
        jLabel.setFont(font);

        jPanel.add(jLabel);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

}

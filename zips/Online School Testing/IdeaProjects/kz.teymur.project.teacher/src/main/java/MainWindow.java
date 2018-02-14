import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 18.01.2015.
 */
public class MainWindow {
    private static JPanel jPanel;

    private static JLabel jLabel;

    private static Font font;

    MainWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);

        jLabel = new JLabel("<html>Hello, it is second version of program. With my program<br> you can provide some test with students" +
                "without wasting<br> any resources. Please check new updates at twitter <br> <center>@shaykemelov</center></html>");
        jPanel.add(jLabel);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public static JPanel getJPanel(){
        return jPanel;
    }
}

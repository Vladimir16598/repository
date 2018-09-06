import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private static JPanel jPanel;

    private static JLabel jLabel;

    private static Font font;

    MainWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        jPanel.setFont(font);
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://mySite.com");
        jPanel.add(WebView);
        jPanel.setBorder(BorderFactory.createEtchedBorder());


    }

    public static JPanel getJPanel(){
        return jPanel;
    }
}

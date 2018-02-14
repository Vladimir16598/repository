import javax.swing.*;
import java.awt.*;

/**
 * Created by iww on 25.01.2015.
 */
public class StatsWindow {

    private static JPanel panel;

    private static Font font;

    StatsWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);
        panel = new JPanel();
        panel.setFont(font);
    }

    public static JPanel getJPanel(){
        return panel;
    }
}

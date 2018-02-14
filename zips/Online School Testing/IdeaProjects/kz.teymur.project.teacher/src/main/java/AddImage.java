import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFileChooser;

/**
 * Created by iww on 24.01.2015.
 */
public class AddImage {

    protected static String imagePath = null;
    protected static File image;
    protected static Font font = new Font("Verdana", Font.PLAIN, 10);

    public String getImage() throws MalformedURLException {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setFont(font);
        int ret = fileOpen.showDialog(null, "Choose file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            imagePath = fileOpen.getSelectedFile().getAbsolutePath();
            image = fileOpen.getSelectedFile();
        }
        return imagePath;
    }
}
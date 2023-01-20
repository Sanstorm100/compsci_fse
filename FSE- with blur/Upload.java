import javax.swing.filechooser.FileSystemView;
import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class Upload extends JFrame {
    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());

    public Upload(BufferedImage img) {
        fc.showSaveDialog(null);

        File f = new File(fc.getSelectedFile().getName()+".PNG");
        try {
            ImageIO.write(img, "PNG", f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

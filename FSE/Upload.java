import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import java.io.*;





public class Upload  extends JFrame   {
    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());

    public Upload(){
        fc.showSaveDialog(null);

    File f = new File("name"); 

	if (f.mkdir() == true) { 
			System.out.println("Directory has been created successfully"); 
		} 
		else { 
			System.out.println("Directory cannot be created"); 
        }

    }
}

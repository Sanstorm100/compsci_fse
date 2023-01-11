import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.*;




public class Upload  extends JFileChooser  {
    JFileChooser fc = new JFileChooser();

    public Upload(){

        File file = fc.getSelectedFile();
        int returnVal = fc.showOpenDialog(FileChooserDemo.this);


    File f = new File("FSE"); 

	
		if (f.mkdir() == true) { 
			System.out.println("Directory has been created successfully"); 
		} 
		else { 
			System.out.println("Directory cannot be created"); 
        }

    }
}

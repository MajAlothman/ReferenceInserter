
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class GUIHelper {
    
    public static String chooseDirectory(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = chooser.showOpenDialog(chooser);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return"";
    }
    public static void copyAndPaste(String forPaste){
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();
        String originalClipboard = null;
        try {
            originalClipboard = (String)systemClipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        copy(forPaste);
        paste();
        try {
            Thread.sleep(20);//If the sleep amount is little or no sleep the method pasted the old content of the clipboard
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        copy(originalClipboard);
    }

    private static void copy(String forPaste) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();
        systemClipboard.setContents(new StringSelection(forPaste), null);
    }

    private static void paste() {
        try{
            Robot paster = new Robot();
            paster.keyPress(KeyEvent.VK_CONTROL);
            paster.keyPress(KeyEvent.VK_V);
            paster.keyRelease(KeyEvent.VK_CONTROL);
            paster.keyRelease(KeyEvent.VK_V);
        }
        catch(java.awt.AWTException e){
            System.out.println("Error while pasting");
            
        }        
    }
    
    public static void main(String[] a){
        copyAndPaste("Hello");
    }
}

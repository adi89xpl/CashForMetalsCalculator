package GUIBase.Helper;

//This is a helper class that handles display and hiding of frames

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

//This class is static so we do not have to instantiate an object of this class - just go ahead a call it directly
public final class GUIHelper {
    //This method will hide whatever frame is displayed and display the main frame
    public static void SetDisplay(JFrame mainFrame, JPanel currentWrapper, String Title){
        //Clear the form from componenets
        ClearFrame(mainFrame);
        //Add current panel and display it
        mainFrame.getContentPane().add(currentWrapper);
        currentWrapper.setVisible(true);
        //revalidate and repaint the panel
        currentWrapper.revalidate();
        currentWrapper.repaint();
        //Change the Frame title
        mainFrame.setTitle(Title);
        //invalidate, revalidate, repaint and pack the new frame
        mainFrame.invalidate();
        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
        mainFrame.pack();
    }
    
    private static void ClearFrame(JFrame f){
        Component[] CompArr = f.getContentPane().getComponents();
        for (int i = 0; i < CompArr.length; i++){
            f.remove(CompArr[i]);
        }
    }
}

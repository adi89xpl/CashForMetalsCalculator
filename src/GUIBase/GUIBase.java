package GUIBase;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class GUIBase extends JFrame {
    private JFrame mainFrame = new JFrame("Cash For Metals Calculator");
   
    public GUIBase(){
        mainFrame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //Set the Frame Dimensions and setResizable(false)
        mainFrame.setPreferredSize(new Dimension(500, 300));
        mainFrame.setResizable(false);
        
        mainFrame.addWindowListener(new GUIBase.ListenCloseWindow());
        
    }
    
    public JFrame getFrame(){
        return mainFrame;
    }
    
    public void DisplayGUI(){
        //Center the frame 
        Dimension ScreenDim = mainFrame.getToolkit().getScreenSize();
        int ScreenWidth = ScreenDim.width;
        int ScreenHeight = ScreenDim.height;
        mainFrame.setLocation(ScreenWidth / 3, ScreenHeight / 3);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
     //On Window Close we want to exit the application
    public class ListenCloseWindow extends WindowAdapter{
        public void WindowClose(WindowEvent e)
        {
            System.exit(0);
        }
    }
}

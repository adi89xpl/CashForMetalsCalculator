package GUIBase.EventHandlers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class btnExit_Handler implements ActionListener {
    protected Component mFrame;
    public btnExit_Handler(Component mainFrame){
        mFrame = mainFrame;
    }
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(mFrame, "Thank You For Using Cash For Metal Calculator!");
        System.exit(0);
    }
}
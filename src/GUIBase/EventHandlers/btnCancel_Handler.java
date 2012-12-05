package GUIBase.EventHandlers;

import GUIBase.GUIModel;
import GUIBase.Helper.GUIHelper;
import GUIBase.PersonalModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class btnCancel_Handler implements ActionListener{
    private JFrame mainFrame;
    public btnCancel_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        GUIModel GUI = new GUIModel();
        GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Cash For Metals Calculator");   
        GUI.addEventHandlers(mainFrame);
    }
}

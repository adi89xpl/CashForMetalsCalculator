package GUIBase.EventHandlers;

import GUIBase.GUIModel;
import GUIBase.Helper.GUIHelper;
import GUIBase.PersonalModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class PersonalModel_btnCancel_Handler implements ActionListener{
    private JFrame mainFrame;
    public PersonalModel_btnCancel_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        GUIModel GUI = new GUIModel();
        GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Create Personal Customer");
        GUI.addEventHandlers(mainFrame);
    }
}

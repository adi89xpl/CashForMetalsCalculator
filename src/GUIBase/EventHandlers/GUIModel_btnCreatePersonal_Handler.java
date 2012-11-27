package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import GUIBase.PersonalModel;
import javax.swing.JFrame;

public class GUIModel_btnCreatePersonal_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnCreatePersonal_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        PersonalModel displayFrame = new PersonalModel(mainFrame);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getContentPanel(), "Create Personal Customer");
    }
}

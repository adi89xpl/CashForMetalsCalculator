package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import GUIBase.CommercialModel;
import javax.swing.JFrame;

public class GUIModel_btnCreateCommercial_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnCreateCommercial_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        CommercialModel displayFrame = new CommercialModel(mainFrame);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getContentPanel(), "Create Commercial Customer");
    }
}

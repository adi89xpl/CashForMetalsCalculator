package GUIBase.EventHandlers;

import GUIBase.DisplayGrandSummaryModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import javax.swing.JFrame;

public class GUIModel_btnDisplayGrandSummary_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnDisplayGrandSummary_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        DisplayGrandSummaryModel displayFrame = new DisplayGrandSummaryModel(mainFrame);
        displayFrame.DisplayCustomer();
        GUIHelper.SetDisplay(mainFrame, displayFrame.getContentPanel(), "Grand Summary");
    }
}

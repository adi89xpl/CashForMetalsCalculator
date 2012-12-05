package GUIBase.EventHandlers;

import GUIBase.DisplayCustomerSummaryModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import javax.swing.JFrame;

public class GUIModel_btnDisplayCustomerSummary_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnDisplayCustomerSummary_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        DisplayCustomerSummaryModel displayFrame = new DisplayCustomerSummaryModel(mainFrame);
        displayFrame.DisplayCustomer();
        GUIHelper.SetDisplay(mainFrame, displayFrame.getContentPanel(), "Customer Summary");
    }
}

package GUIBase.EventHandlers;

import GUIBase.DisplayCustomerModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import javax.swing.JFrame;

public class GUIModel_btnDisplayCustomer_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnDisplayCustomer_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        DisplayCustomerModel displayFrame = new DisplayCustomerModel(mainFrame);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getSearchPanel(), "Customer Lookup");
    }
}

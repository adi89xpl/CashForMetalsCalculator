package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import GUIBase.TransactionModel;
import javax.swing.JFrame;

public class GUIModel_btnCreateTransaction_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnCreateTransaction_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        TransactionModel displayFrame = new TransactionModel(mainFrame);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getSearchPanel(), "Customer Lookup");
    }
}

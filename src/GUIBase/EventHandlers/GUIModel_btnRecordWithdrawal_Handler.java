package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.Helper.*;
import GUIBase.WithdrawalModel;
import javax.swing.JFrame;

public class GUIModel_btnRecordWithdrawal_Handler implements ActionListener {
    protected JFrame mainFrame;
    public GUIModel_btnRecordWithdrawal_Handler(JFrame mFrame){
        mainFrame = mFrame;
    }
    public void actionPerformed(ActionEvent e) {
        WithdrawalModel displayFrame = new WithdrawalModel(mainFrame);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getSearchPanel(), "Withdraw");
    }
}

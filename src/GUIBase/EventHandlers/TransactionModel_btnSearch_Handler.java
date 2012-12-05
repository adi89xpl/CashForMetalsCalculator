package GUIBase.EventHandlers;

import GUIBase.GUIModel;
import GUIBase.Helper.Core;
import GUIBase.Helper.GUIHelper;
import GUIBase.Helper.XMLHelper;
import GUIBase.TransactionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransactionModel_btnSearch_Handler implements ActionListener {
    private JFrame mainFrame;
    private JTextField Search;
    private TransactionModel Tran;
    public TransactionModel_btnSearch_Handler(JFrame mFrame, JTextField s){
        mainFrame = mFrame;
        Search = s;
    }
    
    public void actionPerformed(ActionEvent e){
        if (Search.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide a Customer ID", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!Core.IsNumeric(Search.getText())){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Customer ID", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        long CustomerId = XMLHelper.CustomerLookup(mainFrame, Integer.parseInt(Search.getText()));
        if (CustomerId == 0){
            JOptionPane.showMessageDialog(mainFrame, "The Specified Customer ID Was Not Found", null, JOptionPane.INFORMATION_MESSAGE);
            GUIModel GUI = new GUIModel();
            GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Cash For Metals Calculator");   
            GUI.addEventHandlers(mainFrame);
            return;
        }
        TransactionModel displayFrame = new TransactionModel(mainFrame);
        displayFrame.setCustomer(CustomerId);
        GUIHelper.SetDisplay(mainFrame, displayFrame.getTransactionPanel(), "Create Transaction");
    }
}

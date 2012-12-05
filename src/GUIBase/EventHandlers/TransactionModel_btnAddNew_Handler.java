package GUIBase.EventHandlers;

import DataLayer.Transaction;
import GUIBase.GUIModel;
import GUIBase.Helper.Core;
import GUIBase.Helper.GUIHelper;
import GUIBase.Helper.XMLHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransactionModel_btnAddNew_Handler implements ActionListener {
    private JFrame mainFrame;
    private JTextField gWeight;
    private JTextField pWeight;
    private JTextField sWeight;
    private long CustomerId;
    public TransactionModel_btnAddNew_Handler(JFrame mFrame, JTextField g, JTextField p, JTextField s, long CustId){
        mainFrame = mFrame;
        gWeight = g;
        pWeight = p;
        sWeight = s;
        CustomerId = CustId;
    }
    
    public void actionPerformed(ActionEvent e){
        if (gWeight.getText().isEmpty() && pWeight.getText().isEmpty() && sWeight.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide at Least One Mineral For the Transaction", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!gWeight.getText().isEmpty()){
            if (!Core.IsNumeric(gWeight.getText())){
                JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Value for Gold Weight", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        if (!pWeight.getText().isEmpty()){
            if (!Core.IsNumeric(pWeight.getText())){
                JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Value for Platinum Weight", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        if (!sWeight.getText().isEmpty()){
            if (!Core.IsNumeric(sWeight.getText())){
                JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Value for Silver Weight", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        Transaction Tran = new Transaction();
        Tran.setGoldWeight(Core.toDouble(gWeight.getText()));
        Tran.setPlatinumWeight(Core.toDouble(pWeight.getText()));
        Tran.setSilverWeight(Core.toDouble(sWeight.getText()));
        if (CustomerId > 0){
            try {
                XMLHelper.CreateTransaction(mainFrame, Tran, CustomerId);
                JOptionPane.showMessageDialog(mainFrame, "The Transaction Has Been Recorded Succesfully", null, JOptionPane.INFORMATION_MESSAGE);
                GUIModel GUI = new GUIModel();
                GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Cash For Metals Calculator");
                GUI.addEventHandlers(mainFrame);
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "Ooooops ... Something Went Wrong. Please Restart The App", null, JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(mainFrame, "Customer ID was not found! Please try again", null, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}

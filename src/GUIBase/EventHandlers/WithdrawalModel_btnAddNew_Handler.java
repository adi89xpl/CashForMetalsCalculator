package GUIBase.EventHandlers;

import GUIBase.GUIModel;
import GUIBase.Helper.Core;
import GUIBase.Helper.GUIHelper;
import GUIBase.Helper.UniqueIDFactory;
import GUIBase.Helper.XMLHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WithdrawalModel_btnAddNew_Handler implements ActionListener {
    private JFrame mainFrame;
    private JTextField Amount;
    private long CustomerId;
    public WithdrawalModel_btnAddNew_Handler(JFrame mFrame, JTextField amt, long cId){
        mainFrame = mFrame;
        Amount = amt;
        CustomerId = cId;
    }
    
    public void actionPerformed(ActionEvent e){
        if (Amount.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Value for the Amount to be Withdrawn", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!Core.IsNumeric(Amount.getText())){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide a Numeric Value for the Amount to be Withdrawn", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (Core.toDouble(Amount.getText()) <= 0){
            JOptionPane.showMessageDialog(mainFrame, "Withdrawal Amount Must Be Greater Than 0", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        long TransactionId = UniqueIDFactory.generateUniqueID();
        Calendar c = Calendar.getInstance();
        String TransactionDate = c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH);
         if (CustomerId > 0){
            try {
                XMLHelper.CreateTransaction(mainFrame, CustomerId, TransactionId, TransactionDate, Core.toDouble(Amount.getText()));
                JOptionPane.showMessageDialog(mainFrame, "The Withdrawal Has Been Recorded Succesfully", null, JOptionPane.INFORMATION_MESSAGE);
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

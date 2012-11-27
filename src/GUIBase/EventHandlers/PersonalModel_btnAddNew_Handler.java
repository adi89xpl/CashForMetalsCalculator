package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import GUIBase.Helper.*;


public class PersonalModel_btnAddNew_Handler implements ActionListener {
    private JFrame mainFrame;
    private JTextField cName;
    private JTextField cAddress;
    private JTextField cHomePhone;
    private JTextField cWorkPhone;
    
    public PersonalModel_btnAddNew_Handler(JFrame mFrame, JTextField Name, JTextField Address, JTextField HomePhone, JTextField WorkPhone){
        mainFrame = mFrame;
        cName = Name;
        cAddress = Address;
        cHomePhone = HomePhone;
        cWorkPhone = WorkPhone;
    }
    
    public void actionPerformed(ActionEvent e) {
        boolean bError = false;
        if(cName.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Name");
            bError = true;
        }
        else if(cAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Address");
            bError = true;
        }
        else if(cHomePhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Home Phone");
            bError = true;
        }
        else if(cWorkPhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Work Phone");
            bError = true;
        }
        if(!bError){
            if (XMLHelper.CustomerFileExists()){
                
            }
            else {
                
            }
        }
    }
    
}

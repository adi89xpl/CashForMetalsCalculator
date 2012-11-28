package GUIBase.EventHandlers;

import DataLayer.PersonalCustomer;
import GUIBase.GUIModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import GUIBase.Helper.*;
import org.w3c.dom.Document;


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
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Name", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        else if(cAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Address", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        else if(cHomePhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Home Phone", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        else if(cWorkPhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Work Phone", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        if(!bError){
            Document CustomerDoc = null;
            if (XMLHelper.CustomerFileExists()){
                CustomerDoc = XMLHelper.OpenCustomerFile(mainFrame);
                PersonalCustomer pCustomer = new PersonalCustomer(cName.getText());
                pCustomer.setCustomerAddress(cAddress.getText());
                pCustomer.setHomePhone(cHomePhone.getText());
                pCustomer.setWorkPhone(cWorkPhone.getText());
                XMLHelper.AddPersonal(CustomerDoc, pCustomer, mainFrame);
            }
            else {
                CustomerDoc = XMLHelper.CreateCustomerFile(mainFrame);
                PersonalCustomer pCustomer = new PersonalCustomer(cName.getText());
                pCustomer.setCustomerAddress(cAddress.getText());
                pCustomer.setHomePhone(cHomePhone.getText());
                pCustomer.setWorkPhone(cWorkPhone.getText());
                XMLHelper.AddPersonal(CustomerDoc, pCustomer, mainFrame);
            }
            JOptionPane.showMessageDialog(mainFrame, "The Customer Has Been Succefully Addeded", null, JOptionPane.INFORMATION_MESSAGE);
            GUIModel GUI = new GUIModel();
            GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Create Personal Customer");
            GUI.addEventHandlers(mainFrame);
        }
    }
    
}

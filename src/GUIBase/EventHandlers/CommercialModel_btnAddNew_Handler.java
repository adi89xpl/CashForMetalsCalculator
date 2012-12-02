package GUIBase.EventHandlers;

import DataLayer.CommercialCustomer;
import GUIBase.GUIModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import GUIBase.Helper.*;
import org.w3c.dom.Document;


public class CommercialModel_btnAddNew_Handler implements ActionListener {
    private JFrame mainFrame;
    private JTextField cName;
    private JTextField cAddress;
    private JTextField cContactPerson;
    private JTextField cContactPersonPhone;
    
    public CommercialModel_btnAddNew_Handler(JFrame mFrame, JTextField Name, JTextField Address, JTextField ContactPerson, JTextField ContactPersonPhone){
        mainFrame = mFrame;
        cName = Name;
        cAddress = Address;
        cContactPerson = ContactPerson;
        cContactPersonPhone = ContactPersonPhone;
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
        else if(cContactPerson.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Home Phone", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        else if(cContactPersonPhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, "Please Provide the Customer Work Phone", null, JOptionPane.INFORMATION_MESSAGE);
            bError = true;
        }
        if(!bError){
            Document CustomerDoc = null;
            if (XMLHelper.CustomerFileExists()){
                CustomerDoc = XMLHelper.OpenCustomerFile(mainFrame);
                CommercialCustomer cCustomer = new CommercialCustomer(cName.getText());
                cCustomer.setCustomerAddress(cAddress.getText());
                cCustomer.setContactPerson(cContactPerson.getText());
                cCustomer.setContactPersonPhone(cContactPersonPhone.getText());
                XMLHelper.AddCommercial(CustomerDoc, cCustomer, mainFrame);
            }
            else {
                CustomerDoc = XMLHelper.CreateCustomerFile(mainFrame);
                CommercialCustomer cCustomer = new CommercialCustomer(cName.getText());
                cCustomer.setCustomerAddress(cAddress.getText());
                cCustomer.setContactPerson(cContactPerson.getText());
                cCustomer.setContactPersonPhone(cContactPersonPhone.getText());
                XMLHelper.AddCommercial(CustomerDoc, cCustomer, mainFrame);
            }
            JOptionPane.showMessageDialog(mainFrame, "The Customer Has Been Succefully Addeded", null, JOptionPane.INFORMATION_MESSAGE);
            GUIModel GUI = new GUIModel();
            GUIHelper.SetDisplay(mainFrame, GUI.getContentPanel(), "Create Commercial Customer");
            GUI.addEventHandlers(mainFrame);
        }
    }
    
}

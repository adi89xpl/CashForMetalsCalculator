package GUIBase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import GUIBase.EventHandlers.*;
import javax.swing.JFrame;

public class PersonalModel {
   //Frame
    private JPanel PersonalModelWrapper = new JPanel();
    //Panels
    private JPanel pnlButtons = new JPanel();
    private JPanel pnlName = new JPanel();
    private JPanel pnlAddress = new JPanel();
    private JPanel pnlHomePhone = new JPanel();
    private JPanel pnlWorkPhone = new JPanel();
    //Controls
    private JLabel lblName = new JLabel("Customer Name");
    private JLabel lblAddress = new JLabel("Customer Address");
    private JLabel lblHomePhone = new JLabel("Customer Home Phone");
    private JLabel lblWorkPhone = new JLabel("Customer Work Phone");
    
    private JTextField txtName = new JTextField();
    private JTextField txtAddress = new JTextField();
    private JTextField txtHomePhone = new JTextField();
    private JTextField txtWorkPhone = new JTextField();
    
    private JButton btnAddPersonal = new JButton("Add Customer");
    private JButton btnCancel = new JButton("Cancel");
    
    private JFrame mainFrame;
    public PersonalModel(JFrame mFrame){
        mainFrame = mFrame;
        //Set the FlowLayout and the Dimensions for panels
        pnlName.setPreferredSize(new Dimension(450, 50));
        pnlName.setLayout(new FlowLayout());
        pnlAddress.setPreferredSize(new Dimension(450, 50));
        pnlAddress.setLayout(new FlowLayout());
        pnlHomePhone.setPreferredSize(new Dimension(450, 50));
        pnlHomePhone.setLayout(new FlowLayout());
        pnlWorkPhone.setPreferredSize(new Dimension(450, 50));
        pnlWorkPhone.setLayout(new FlowLayout());
        
        //Add buttons and labels to panels
        //Work
        lblWorkPhone.setPreferredSize(new Dimension(450, 20));
        lblWorkPhone.setHorizontalAlignment(JLabel.CENTER);
        txtWorkPhone.setPreferredSize(new Dimension(250, 20));
        pnlWorkPhone.add(lblWorkPhone);
        pnlWorkPhone.add(txtWorkPhone);
        //Home
        lblHomePhone.setPreferredSize(new Dimension(450, 20));
        lblHomePhone.setHorizontalAlignment(JLabel.CENTER);
        txtHomePhone.setPreferredSize(new Dimension(250, 20));
        pnlHomePhone.add(lblHomePhone);
        pnlHomePhone.add(txtHomePhone);
        //Address
        lblAddress.setPreferredSize(new Dimension(450, 20));
        lblAddress.setHorizontalAlignment(JLabel.CENTER);
        txtAddress.setPreferredSize(new Dimension(250, 20));
        pnlAddress.add(lblAddress);
        pnlAddress.add(txtAddress);
        //Name
        lblName.setPreferredSize(new Dimension(450, 20));
        lblName.setHorizontalAlignment(JLabel.CENTER);
        txtName.setPreferredSize(new Dimension(250, 20));
        pnlName.add(lblName);
        pnlName.add(txtName);
        //Buttons
        btnAddPersonal.setPreferredSize(new Dimension(200, 30));
        btnCancel.setPreferredSize(new Dimension(200, 30));
        pnlButtons.add(btnAddPersonal);
        pnlButtons.add(btnCancel);
        
        PersonalModelWrapper.setLayout(new FlowLayout());
        PersonalModelWrapper.add(pnlButtons, FlowLayout.LEFT);
        PersonalModelWrapper.add(pnlWorkPhone, FlowLayout.LEFT);
        PersonalModelWrapper.add(pnlHomePhone, FlowLayout.LEFT);
        PersonalModelWrapper.add(pnlAddress, FlowLayout.LEFT);
        PersonalModelWrapper.add(pnlName, FlowLayout.LEFT);
        //Add the event handler to the button
        btnCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnAddPersonal.addActionListener(new PersonalModel_btnAddNew_Handler(mainFrame, txtName, txtAddress, txtHomePhone, txtWorkPhone));
    }
    
    public JPanel getContentPanel(){
        return PersonalModelWrapper;
    }
}
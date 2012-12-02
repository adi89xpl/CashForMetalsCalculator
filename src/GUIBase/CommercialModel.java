package GUIBase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import GUIBase.EventHandlers.*;
import javax.swing.JFrame;

public class CommercialModel {
   //Frame
    private JPanel CommercialModelWrapper = new JPanel();
    //Panels
    private JPanel pnlButtons = new JPanel();
    private JPanel pnlName = new JPanel();
    private JPanel pnlAddress = new JPanel();
    private JPanel pnlContactPerson = new JPanel();
    private JPanel pnlContactPersonPhone = new JPanel();
    //Controls
    private JLabel lblName = new JLabel("Commercial Customer Name");
    private JLabel lblAddress = new JLabel("Commercial Customer Address");
    private JLabel lblContactPerson = new JLabel("Commercial Customer Home Phone");
    private JLabel lblContactPersonPhone = new JLabel("Commercial Customer Work Phone");
    
    private JTextField txtName = new JTextField();
    private JTextField txtAddress = new JTextField();
    private JTextField txtContactPerson = new JTextField();
    private JTextField txtContactPersonPhone = new JTextField();
    
    private JButton btnAddCommercial = new JButton("Add Commercial Customer");
    private JButton btnCancel = new JButton("Cancel");
    
    private JFrame mainFrame;
    public CommercialModel(JFrame mFrame){
        mainFrame = mFrame;
        //Set the FlowLayout and the Dimensions for panels
        pnlName.setPreferredSize(new Dimension(450, 50));
        pnlName.setLayout(new FlowLayout());
        pnlAddress.setPreferredSize(new Dimension(450, 50));
        pnlAddress.setLayout(new FlowLayout());
        pnlContactPerson.setPreferredSize(new Dimension(450, 50));
        pnlContactPerson.setLayout(new FlowLayout());
        pnlContactPersonPhone.setPreferredSize(new Dimension(450, 50));
        pnlContactPersonPhone.setLayout(new FlowLayout());
        
        //Add buttons and labels to panels
        lblContactPersonPhone.setPreferredSize(new Dimension(450, 20));
        lblContactPersonPhone.setHorizontalAlignment(JLabel.CENTER);
        txtContactPersonPhone.setPreferredSize(new Dimension(250, 20));
        pnlContactPersonPhone.add(lblContactPersonPhone);
        pnlContactPersonPhone.add(txtContactPersonPhone);
        //Home
        lblContactPerson.setPreferredSize(new Dimension(450, 20));
        lblContactPerson.setHorizontalAlignment(JLabel.CENTER);
        txtContactPerson.setPreferredSize(new Dimension(250, 20));
        pnlContactPerson.add(lblContactPerson);
        pnlContactPerson.add(txtContactPerson);
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
        btnAddCommercial.setPreferredSize(new Dimension(200, 30));
        btnCancel.setPreferredSize(new Dimension(200, 30));
        pnlButtons.add(btnAddCommercial);
        pnlButtons.add(btnCancel);
        
        //Container framePane = frame.getContentPane();
        CommercialModelWrapper.setLayout(new FlowLayout());
        CommercialModelWrapper.add(pnlButtons, FlowLayout.LEFT);
        CommercialModelWrapper.add(pnlContactPersonPhone, FlowLayout.LEFT);
        CommercialModelWrapper.add(pnlContactPerson, FlowLayout.LEFT);
        CommercialModelWrapper.add(pnlAddress, FlowLayout.LEFT);
        CommercialModelWrapper.add(pnlName, FlowLayout.LEFT);
        //Add the event handler to the button
        btnCancel.addActionListener(new PersonalModel_btnCancel_Handler(mainFrame));
        btnAddCommercial.addActionListener(new PersonalModel_btnAddNew_Handler(mainFrame, txtName, txtAddress, txtContactPerson, txtContactPersonPhone));
    }
    
    public JPanel getContentPanel(){
        return CommercialModelWrapper;
    }
}
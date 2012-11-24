package GUIBase;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import GUIBase.EventHandlers.*;

public class PersonalModel{
   //Frame
    private JFrame frame = new JFrame("Create Personal Customer");
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
    
    public PersonalModel(){
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setPreferredSize(new Dimension(450, 300));
        frame.setResizable(false);
        
        pnlName.setPreferredSize(new Dimension(450, 50));
        pnlName.setLayout(new FlowLayout());
        pnlAddress.setPreferredSize(new Dimension(450, 50));
        pnlAddress.setLayout(new FlowLayout());
        pnlHomePhone.setPreferredSize(new Dimension(450, 50));
        pnlHomePhone.setLayout(new FlowLayout());
        pnlWorkPhone.setPreferredSize(new Dimension(450, 50));
        pnlWorkPhone.setLayout(new FlowLayout());
        
        //Add buttons and labels to panels
        lblWorkPhone.setPreferredSize(new Dimension(450, 20));
        lblWorkPhone.setHorizontalAlignment(JLabel.CENTER);
        txtWorkPhone.setPreferredSize(new Dimension(250, 20));
        pnlWorkPhone.add(lblWorkPhone);
        pnlWorkPhone.add(txtWorkPhone);
        
        lblHomePhone.setPreferredSize(new Dimension(450, 20));
        lblHomePhone.setHorizontalAlignment(JLabel.CENTER);
        txtHomePhone.setPreferredSize(new Dimension(250, 20));
        pnlHomePhone.add(lblHomePhone);
        pnlHomePhone.add(txtHomePhone);
        
        
        lblAddress.setPreferredSize(new Dimension(450, 20));
        lblAddress.setHorizontalAlignment(JLabel.CENTER);
        txtAddress.setPreferredSize(new Dimension(250, 20));
        pnlAddress.add(lblAddress);
        pnlAddress.add(txtAddress);
        
        lblName.setPreferredSize(new Dimension(450, 20));
        lblName.setHorizontalAlignment(JLabel.CENTER);
        txtName.setPreferredSize(new Dimension(250, 20));
        pnlName.add(lblName);
        pnlName.add(txtName);
        
        btnAddPersonal.setPreferredSize(new Dimension(200, 30));
        btnCancel.setPreferredSize(new Dimension(200, 30));
        pnlButtons.add(btnAddPersonal);
        pnlButtons.add(btnCancel);
        
        Container framePane = frame.getContentPane();
        framePane.setLayout(new FlowLayout());
        framePane.add(pnlButtons, FlowLayout.LEFT);
        framePane.add(pnlWorkPhone, FlowLayout.LEFT);
        framePane.add(pnlHomePhone, FlowLayout.LEFT);
        framePane.add(pnlAddress, FlowLayout.LEFT);
        framePane.add(pnlName, FlowLayout.LEFT);
        
        frame.addWindowListener(new PersonalModel.ListenCloseWindow());
        
        btnCancel.addActionListener(new AddPersonal_Cancel_Handler( frame));
    }
    
    public class ListenCloseWindow extends WindowAdapter {
        public void WindowClose(WindowEvent e)
        {
            System.exit(0);
        }
    }
    
    //Method to display the frame
    public void DisplayFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
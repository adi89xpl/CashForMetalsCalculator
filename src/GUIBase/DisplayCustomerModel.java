package GUIBase;

import GUIBase.EventHandlers.DisplayCustomerModel_btnSearch_Handler;
import GUIBase.EventHandlers.btnCancel_Handler;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayCustomerModel {
    //wrappers
    private JPanel DisplayWrapper = new JPanel();
    private JPanel DisplayModelSearchWrapper = new JPanel();
    private JPanel DisplayModelWrapper = new JPanel();
    //panels
    private JPanel pnlSearch = new JPanel();
    
    private JPanel pnlDisplay = new JPanel();
    //Labels
    private JLabel lblSearch = new JLabel("Customer Lookup");
    
    private JLabel lblCustomerInfo = new JLabel("Customer Info");
    //Textboxes
    private JTextField txtSearch = new JTextField();
    
    private JTextArea txtDisplayArea = new JTextArea();
    private JScrollPane DisplayAreaScroll = new JScrollPane();
    //buttons
    private JButton btnSearch = new JButton("Search");
    private JButton btnCancel = new JButton("Cancel");
    
    private JFrame mainFrame;
    //This variable holds the Id Of the customer/ if found
    private long CustomerId;
    public DisplayCustomerModel(JFrame mFrame){
        mainFrame = mFrame;
        //set the FlowLayout and size for each panel
        DisplayWrapper.setPreferredSize(new Dimension(450, 300));
        DisplayWrapper.setLayout(new FlowLayout());
        DisplayModelSearchWrapper.setPreferredSize(new Dimension(450, 50));
        DisplayModelSearchWrapper.setLayout(new FlowLayout());
        DisplayModelWrapper.setPreferredSize(new Dimension(450, 50));
        DisplayModelWrapper.setLayout(new FlowLayout());
        pnlSearch.setPreferredSize(new Dimension(450, 250));
        pnlSearch.setLayout(new FlowLayout());
        pnlDisplay.setPreferredSize(new Dimension(450, 250));
        pnlDisplay.setLayout(new FlowLayout());
        //Add buttons, labels and textboxes to panels
        lblSearch.setPreferredSize(new Dimension(450, 20));
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        txtSearch.setPreferredSize(new Dimension(250, 20));
        btnSearch.setPreferredSize(new Dimension(200, 35));
        btnCancel.setPreferredSize(new Dimension(200, 35));
        pnlSearch.add(lblSearch);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
        pnlSearch.add(btnCancel);
        DisplayModelSearchWrapper.add(pnlSearch, FlowLayout.LEFT);
        
        lblCustomerInfo.setPreferredSize(new Dimension(450, 20));
        lblCustomerInfo.setHorizontalAlignment(JLabel.CENTER);
        txtDisplayArea.setPreferredSize(new Dimension(450, 240));
        DisplayAreaScroll = new JScrollPane(txtDisplayArea);
        pnlDisplay.add(lblCustomerInfo);
        //pnlDisplay.add(txtDisplayArea);
        pnlDisplay.add(DisplayAreaScroll);
        
        //DisplayModelWrapper.add(btnCancel, FlowLayout.LEFT);
        DisplayModelWrapper.add(pnlDisplay, FlowLayout.LEFT);
               
        btnCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnSearch.addActionListener(new DisplayCustomerModel_btnSearch_Handler(mainFrame, txtSearch));
        
    }
    
     public JPanel getSearchPanel(){
        return DisplayModelSearchWrapper;
    }
     
     public JPanel getDisplayPanel(){
         return DisplayModelWrapper;
     }
     
     public void setCustomer(long Cust){
        CustomerId = Cust;
        DisplayCustomer(Cust);
    }
     
     private void DisplayCustomer(long cId){
         
     }
}

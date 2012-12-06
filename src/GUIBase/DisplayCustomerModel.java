package GUIBase;

import GUIBase.EventHandlers.DisplayCustomerModel_btnSearch_Handler;
import GUIBase.EventHandlers.btnCancel_Handler;
import GUIBase.Helper.XMLHelper;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

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
    //button
    private JButton btnGoBack = new JButton("Back");
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
        pnlDisplay.add(lblCustomerInfo);
        
        DisplayModelWrapper.add(pnlDisplay, FlowLayout.LEFT);
               
        btnGoBack.addActionListener(new btnCancel_Handler(mainFrame));
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
         String Data = XMLHelper.getCustomerDisplayData(mainFrame, CustomerId);
         txtDisplayArea.setText(Data);
         txtDisplayArea.setCaretPosition(0);
         txtDisplayArea.setEditable(false);
         DisplayAreaScroll = new JScrollPane(txtDisplayArea);
         DisplayAreaScroll.setPreferredSize(new Dimension(450, 185));
         pnlDisplay.add(DisplayAreaScroll);
         btnGoBack.setPreferredSize(new Dimension(200, 30));
         pnlDisplay.add(btnGoBack);
     }
}

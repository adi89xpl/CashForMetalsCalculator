package GUIBase;

import GUIBase.EventHandlers.WithdrawalModel_btnAddNew_Handler;
import GUIBase.EventHandlers.WithdrawalModel_btnSearch_Handler;
import GUIBase.EventHandlers.btnCancel_Handler;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawalModel {
    //wrappers
    private JPanel WithdrawalWrapper = new JPanel();
    private JPanel WithdrawalModelSearchWrapper = new JPanel();
    private JPanel WithdrawalModelWrapper = new JPanel();
    //panels
    private JPanel pnlSearch = new JPanel();
    
    private JPanel pnlAmount = new JPanel();
    //Labels
    private JLabel lblSearch = new JLabel("Customer Lookup");
    
    private JLabel lblAmount = new JLabel("Withdrawal Amount");
    //Textboxes
    private JTextField txtSearch = new JTextField();
    
    private JTextField txtAmount = new JTextField();
    //buttons
    private JButton btnSearch = new JButton("Search");
    
    private JButton btnWithdraw = new JButton("Commit Withdrawal");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnWithdrawCancel = new JButton("Cancel");
    
    private JFrame mainFrame;
    //This variable holds the Id Of the customer/ if found
    private long CustomerId;
    public WithdrawalModel(JFrame mFrame){
        mainFrame = mFrame;
        //set the FlowLayout and size for each panel
        WithdrawalWrapper.setPreferredSize(new Dimension(450, 300));
        WithdrawalWrapper.setLayout(new FlowLayout());
        WithdrawalModelSearchWrapper.setPreferredSize(new Dimension(450, 50));
        WithdrawalModelSearchWrapper.setLayout(new FlowLayout());
        WithdrawalModelWrapper.setPreferredSize(new Dimension(450, 50));
        WithdrawalModelWrapper.setLayout(new FlowLayout());
        pnlSearch.setPreferredSize(new Dimension(450, 250));
        pnlSearch.setLayout(new FlowLayout());
        pnlAmount.setPreferredSize(new Dimension(450, 50));
        pnlAmount.setLayout(new FlowLayout());
        //Add buttons, labels and textboxes to panels
        lblSearch.setPreferredSize(new Dimension(450, 20));
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        txtSearch.setPreferredSize(new Dimension(250, 20));
        btnSearch.setPreferredSize(new Dimension(200, 35));
        btnCancel.setPreferredSize(new Dimension(200, 35));
        btnWithdrawCancel.setPreferredSize(new Dimension(200, 35));
        pnlSearch.add(lblSearch);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
        pnlSearch.add(btnWithdrawCancel);
        WithdrawalModelSearchWrapper.add(pnlSearch, FlowLayout.LEFT);
        
        lblAmount.setPreferredSize(new Dimension(450, 20));
        lblAmount.setHorizontalAlignment(JLabel.CENTER);
        txtAmount.setPreferredSize(new Dimension(250, 20));
        pnlAmount.add(lblAmount);
        pnlAmount.add(txtAmount);
        
        btnWithdraw.setPreferredSize(new Dimension(200, 35));
        
        WithdrawalModelWrapper.add(btnCancel, FlowLayout.LEFT);
        WithdrawalModelWrapper.add(btnWithdraw, FlowLayout.LEFT);
        WithdrawalModelWrapper.add(pnlAmount, FlowLayout.LEFT);
               
        btnCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnWithdrawCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnSearch.addActionListener(new WithdrawalModel_btnSearch_Handler(mainFrame, txtSearch));
        
    }
    
     public JPanel getSearchPanel(){
        return WithdrawalModelSearchWrapper;
    }
     
     public JPanel getWithdrawalPanel(){
         return WithdrawalModelWrapper;
     }
     
     public void setCustomer(long Cust){
        CustomerId = Cust;
        btnWithdraw.addActionListener(new WithdrawalModel_btnAddNew_Handler(mainFrame, txtAmount, CustomerId));
    }
}

package GUIBase;

import GUIBase.EventHandlers.TransactionModel_btnAddNew_Handler;
import GUIBase.EventHandlers.TransactionModel_btnSearch_Handler;
import GUIBase.EventHandlers.btnCancel_Handler;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.w3c.dom.Element;

public class TransactionModel {
    //wrappers
    private JPanel TransactionWrapper = new JPanel();
    private JPanel TransactionModelSearchWrapper = new JPanel();
    private JPanel TransactionModelWrapper = new JPanel();
    //panels
    private JPanel pnlSearch = new JPanel();
    
    private JPanel pnlGold = new JPanel();
    private JPanel pnlPlatinum = new JPanel();
    private JPanel pnlSilver = new JPanel();
    private JPanel pnlTransactionTotal = new JPanel();
    //Labels
    private JLabel lblSearch = new JLabel("Customer Lookup");
    
    private JLabel lblGoldWeight = new JLabel("Gold Weight");
    private JLabel lblPlatinumWeight = new JLabel("Platinum Weight");
    private JLabel lblSilverWeight = new JLabel("Silver Weight");
    private JLabel lblTransactionTotal = new JLabel("Transaction Totals");
    private JLabel lblTotalGold = new JLabel();
    private JLabel lblTotalPlatinum = new JLabel();
    private JLabel lblTotalSilver = new JLabel();
    private JLabel lblGrandTotal = new JLabel();
    //Textboxes
    private JTextField txtSearch = new JTextField();
    
    private JTextField txtGoldWeight = new JTextField();
    private JTextField txtPlatinumWeight = new JTextField();
    private JTextField txtSilverWeight = new JTextField();
    //buttons
    private JButton btnSearch = new JButton("Search");
    
    private JButton btnAddTransaction = new JButton("Commit Transaction");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnSearchCancel = new JButton("Cancel");
    
    private JFrame mainFrame;
    //This variable holds the Id Of the customer/ if found
    private long CustomerId;
    public TransactionModel(JFrame mFrame){
        mainFrame = mFrame;
        //set the FlowLayout and size for each panel
        TransactionWrapper.setPreferredSize(new Dimension(450, 300));
        TransactionWrapper.setLayout(new FlowLayout());
        TransactionModelSearchWrapper.setPreferredSize(new Dimension(450, 50));
        TransactionModelSearchWrapper.setLayout(new FlowLayout());
        TransactionModelWrapper.setPreferredSize(new Dimension(450, 50));
        TransactionModelWrapper.setLayout(new FlowLayout());
        pnlSearch.setPreferredSize(new Dimension(450, 250));
        pnlSearch.setLayout(new FlowLayout());
        pnlGold.setPreferredSize(new Dimension(450, 50));
        pnlGold.setLayout(new FlowLayout());
        pnlPlatinum.setPreferredSize(new Dimension(450, 50));
        pnlPlatinum.setLayout(new FlowLayout());
        pnlSilver.setPreferredSize(new Dimension(450, 50));
        pnlSilver.setLayout(new FlowLayout());    
        pnlTransactionTotal.setPreferredSize(new Dimension(450, 50));
        pnlTransactionTotal.setLayout(new FlowLayout());
        //Add buttons, labels and textboxes to panels
        lblSearch.setPreferredSize(new Dimension(450, 20));
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        txtSearch.setPreferredSize(new Dimension(250, 20));
        btnSearch.setPreferredSize(new Dimension(200, 35));
        btnCancel.setPreferredSize(new Dimension(200, 35));
        btnSearchCancel.setPreferredSize(new Dimension(200, 35));
        pnlSearch.add(lblSearch);
        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
        pnlSearch.add(btnSearchCancel);
        TransactionModelSearchWrapper.add(pnlSearch, FlowLayout.LEFT);
        
        lblGoldWeight.setPreferredSize(new Dimension(450, 20));
        lblGoldWeight.setHorizontalAlignment(JLabel.CENTER);
        txtGoldWeight.setPreferredSize(new Dimension(250, 20));
        pnlGold.add(lblGoldWeight);
        pnlGold.add(txtGoldWeight);
        
        lblPlatinumWeight.setPreferredSize(new Dimension(450, 20));
        lblPlatinumWeight.setHorizontalAlignment(JLabel.CENTER);
        txtPlatinumWeight.setPreferredSize(new Dimension(250, 20));
        pnlPlatinum.add(lblPlatinumWeight);
        pnlPlatinum.add(txtPlatinumWeight);
        
        lblSilverWeight.setPreferredSize(new Dimension(450, 20));
        lblSilverWeight.setHorizontalAlignment(JLabel.CENTER);
        txtSilverWeight.setPreferredSize(new Dimension(250, 20));
        pnlSilver.add(lblSilverWeight);
        pnlSilver.add(txtSilverWeight);
        
        btnAddTransaction.setPreferredSize(new Dimension(200, 35));
        
        TransactionModelWrapper.add(btnCancel, FlowLayout.LEFT);
        TransactionModelWrapper.add(btnAddTransaction, FlowLayout.LEFT);
        TransactionModelWrapper.add(pnlSilver, FlowLayout.LEFT);
        TransactionModelWrapper.add(pnlPlatinum, FlowLayout.LEFT);
        TransactionModelWrapper.add(pnlGold, FlowLayout.LEFT);
        
        //TransactionModelWrapper.add(pnlGold, FlowLayout.LEFT);
        //TransactionModelWrapper.add(pnlPlatinum, FlowLayout.LEFT);
        //TransactionModelWrapper.add(pnlSilver, FlowLayout.LEFT);
        //TransactionModelWrapper.add(btnAddTransaction, FlowLayout.LEFT);
        //TransactionModelWrapper.add(btnCancel, FlowLayout.LEFT);
        
        btnCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnSearchCancel.addActionListener(new btnCancel_Handler(mainFrame));
        btnSearch.addActionListener(new TransactionModel_btnSearch_Handler(mainFrame, txtSearch));
        
    }
    
     public JPanel getSearchPanel(){
        return TransactionModelSearchWrapper;
    }
     
     public JPanel getTransactionPanel(){
         return TransactionModelWrapper;
     }
     
     public void setCustomer(long Cust){
        CustomerId = Cust;
        btnAddTransaction.addActionListener(new TransactionModel_btnAddNew_Handler(mainFrame, txtGoldWeight, txtPlatinumWeight, txtSilverWeight, CustomerId));
    }
}

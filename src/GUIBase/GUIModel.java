package GUIBase;
import java.awt.*;
import javax.swing.*;
import GUIBase.EventHandlers.*;

//This model is resonsible for the main menu of the application
public class GUIModel {
    //Frame
    //private JFrame frame = new JFrame("Cash For Metals Calculator");
    //Panels - It will be 2 columns with 4 rows
    //each panel will contain one button to handle the requests
    private JPanel GUIModelWrapper = new JPanel();
    private JPanel pnlCreatePersonal = new JPanel();
    private JPanel pnlCreateCommercial = new JPanel();
    private JPanel pnlRecordTransaction = new JPanel();
    private JPanel pnlRecordWithdrawal = new JPanel();
    private JPanel pnlDisplayCustomer = new JPanel();
    private JPanel pnlDisplayCustomerSummary = new JPanel();
    private JPanel pnlDisplayGrandSummary = new JPanel();
    private JPanel pnlExit = new JPanel();
    //Buttons for each panel
    private JButton btnCreatePersonal = new JButton("Create Personal Customer");
    private JButton btnCreateCommercial = new JButton("Create Commercial Customer");
    private JButton btnRecordTransaction = new JButton("Record Transaction");
    private JButton btnRecordWithdrawal = new JButton("Make Withdrawal");
    private JButton btnDisplayCustomer = new JButton("Display Customer");
    private JButton btnDisplayCustomerSummary = new JButton("Display Customer Summary");
    private JButton btnDisplayGrandSummary = new JButton("Display Grand Summary");
    private JButton btnExit = new JButton("Exit");
    
    public GUIModel()
    {
        //frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnlDisplayGrandSummary.setPreferredSize(new Dimension(225, 60));
        pnlDisplayCustomerSummary.setPreferredSize(new Dimension(225, 60));
        pnlDisplayCustomer.setPreferredSize(new Dimension(225, 60));
        pnlRecordWithdrawal.setPreferredSize(new Dimension(225, 60));
        pnlRecordTransaction.setPreferredSize(new Dimension(225, 60));
        pnlCreateCommercial.setPreferredSize(new Dimension(225, 60));
        pnlCreatePersonal.setPreferredSize(new Dimension(225, 60));
        
        btnExit.setPreferredSize(new Dimension(225, 50));
        btnDisplayGrandSummary.setPreferredSize(new Dimension(225, 50));
        btnDisplayCustomerSummary.setPreferredSize(new Dimension(225, 50));
        btnDisplayCustomer.setPreferredSize(new Dimension(225, 50));
        btnRecordWithdrawal.setPreferredSize(new Dimension(225, 50));
        btnRecordTransaction.setPreferredSize(new Dimension(225, 50));
        btnCreateCommercial.setPreferredSize(new Dimension(225, 50));
        btnCreatePersonal.setPreferredSize(new Dimension(225, 50));
        
        //Let's add the buttons to the panels and then panels to the wrapper panel
        pnlExit.add(btnExit);
        pnlDisplayGrandSummary.add(btnDisplayGrandSummary);
        pnlDisplayCustomerSummary.add(btnDisplayCustomerSummary);
        pnlDisplayCustomer.add(btnDisplayCustomer);
        pnlRecordWithdrawal.add(btnRecordWithdrawal);
        pnlRecordTransaction.add(btnRecordTransaction);
        pnlCreateCommercial.add(btnCreateCommercial);
        pnlCreatePersonal.add(btnCreatePersonal);
        
        //Let's setup the flow layout for this application's interface
        //and add the panels to the frame
        GUIModelWrapper.setLayout(new FlowLayout());
        GUIModelWrapper.add(pnlExit, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlDisplayGrandSummary, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlDisplayCustomerSummary, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlDisplayCustomer, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlRecordWithdrawal, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlRecordTransaction, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlCreateCommercial, FlowLayout.LEFT);
        GUIModelWrapper.add(pnlCreatePersonal, FlowLayout.LEFT);
    }
    
    public void addEventHandlers(JFrame mainFrame){
        //Add ActionListeners to Buttons
        btnExit.addActionListener(new btnExit_Handler(mainFrame));
        btnCreatePersonal.addActionListener(new GUIModel_btnCreatePersonal_Handler(mainFrame));
        btnCreateCommercial.addActionListener(new GUIModel_btnCreateCommercial_Handler(mainFrame));
        btnRecordTransaction.addActionListener(new GUIModel_btnCreateTransaction_Handler(mainFrame));
        btnRecordWithdrawal.addActionListener(new GUIModel_btnRecordWithdrawal_Handler(mainFrame));
        btnDisplayCustomer.addActionListener(new GUIModel_btnDisplayCustomer_Handler(mainFrame));
        btnDisplayCustomerSummary.addActionListener(new GUIModel_btnDisplayCustomerSummary_Handler(mainFrame));
        btnDisplayGrandSummary.addActionListener(new GUIModel_btnDisplayGrandSummary_Handler(mainFrame));
    }
    
    public JPanel getContentPanel(){
        return GUIModelWrapper;
    }
    
   
}



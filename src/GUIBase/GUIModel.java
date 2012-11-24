package GUIBase;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import GUIBase.EventHandlers.*;

public class GUIModel {
    //Frame
    private JFrame frame = new JFrame("Cash For Metal Calculator");
    //Panels - It will be 2 columns with 4 rows
    //each panel will contain one button to handle the requests
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
        frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnlDisplayGrandSummary.setPreferredSize(new Dimension(200, 60));
        pnlDisplayCustomerSummary.setPreferredSize(new Dimension(200, 60));
        pnlDisplayCustomer.setPreferredSize(new Dimension(200, 60));
        pnlRecordWithdrawal.setPreferredSize(new Dimension(200, 60));
        pnlRecordTransaction.setPreferredSize(new Dimension(200, 60));
        pnlCreateCommercial.setPreferredSize(new Dimension(200, 60));
        pnlCreatePersonal.setPreferredSize(new Dimension(200, 60));
        
        btnExit.setPreferredSize(new Dimension(200, 50));
        btnDisplayGrandSummary.setPreferredSize(new Dimension(200, 50));
        btnDisplayCustomerSummary.setPreferredSize(new Dimension(200, 50));
        btnDisplayCustomer.setPreferredSize(new Dimension(200, 50));
        btnRecordWithdrawal.setPreferredSize(new Dimension(200, 50));
        btnRecordTransaction.setPreferredSize(new Dimension(200, 50));
        btnCreateCommercial.setPreferredSize(new Dimension(200, 50));
        btnCreatePersonal.setPreferredSize(new Dimension(200, 50));
        
        //Add ActionListeners to Buttons
        btnExit.addActionListener(new btnExit_Handler(frame));
        btnCreatePersonal.addActionListener(new btnCreatePersonal_Handler());
        
        //Let's add the buttons to the panels and then panels to the frame
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
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(pnlExit, FlowLayout.LEFT);
        frame.getContentPane().add(pnlDisplayGrandSummary, FlowLayout.LEFT);
        frame.getContentPane().add(pnlDisplayCustomerSummary, FlowLayout.LEFT);
        frame.getContentPane().add(pnlDisplayCustomer, FlowLayout.LEFT);
        frame.getContentPane().add(pnlRecordWithdrawal, FlowLayout.LEFT);
        frame.getContentPane().add(pnlRecordTransaction, FlowLayout.LEFT);
        frame.getContentPane().add(pnlCreateCommercial, FlowLayout.LEFT);
        frame.getContentPane().add(pnlCreatePersonal, FlowLayout.LEFT);
        
        frame.setPreferredSize(new Dimension(450, 300));
        frame.setResizable(false);
        
        frame.addWindowListener(new ListenCloseWindow());
    }
    
    public class ListenCloseWindow extends WindowAdapter{
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



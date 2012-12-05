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

public class DisplayCustomerSummaryModel {
    //wrappers
    private JPanel DisplayCustomerSummaryModelWrapper = new JPanel();
    //panels
    private JPanel pnlDisplay = new JPanel();
    //Labels
    private JLabel lblCustomers = new JLabel("Customers");
    //button
    private JButton btnGoBack = new JButton("Back");
    //TextArea
    private JTextArea txtDisplayArea = new JTextArea();
    private JScrollPane DisplayAreaScroll = new JScrollPane();
    
    private JFrame mainFrame;
    public DisplayCustomerSummaryModel(JFrame mFrame){
        mainFrame = mFrame;
        //set the FlowLayout and size for each panel
        DisplayCustomerSummaryModelWrapper.setPreferredSize(new Dimension(450, 300));
        DisplayCustomerSummaryModelWrapper.setLayout(new FlowLayout());
        pnlDisplay.setPreferredSize(new Dimension(450, 250));
        pnlDisplay.setLayout(new FlowLayout());
        //Add buttons, labels and textboxes to panels
        lblCustomers.setPreferredSize(new Dimension(450, 20));
        lblCustomers.setHorizontalAlignment(JLabel.CENTER);
        pnlDisplay.add(lblCustomers);
        
        DisplayCustomerSummaryModelWrapper.add(pnlDisplay, FlowLayout.LEFT);
               
        btnGoBack.addActionListener(new btnCancel_Handler(mainFrame));
    }
    
     public JPanel getContentPanel(){
        return DisplayCustomerSummaryModelWrapper;
    }
     
     public void DisplayCustomer(){
         String Data = XMLHelper.getCustomerSummaryDisplayData(mainFrame);
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

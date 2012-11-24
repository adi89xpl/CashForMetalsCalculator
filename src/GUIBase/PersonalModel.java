package GUIBase;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonalModel {
   //Frame
    private JFrame frame = new JFrame("Create Personal Customer");
    //Panels
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
        
        pnlName.setPreferredSize(new Dimension(50, 150));
        pnlAddress.setPreferredSize(new Dimension(50, 150));
        pnlHomePhone.setPreferredSize(new Dimension(50, 150));
        pnlWorkPhone.setPreferredSize(new Dimension(50, 150));
        
        
        
        
        
        frame.addWindowListener(new PersonalModel.ListenCloseWindow());
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
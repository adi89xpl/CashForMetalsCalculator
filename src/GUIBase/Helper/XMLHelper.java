package GUIBase.Helper;

import DataLayer.Account;
import DataLayer.CommercialCustomer;
import DataLayer.PersonalCustomer;
import DataLayer.Transaction;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public final class XMLHelper {
    //Check if the file exists
    public static boolean CustomerFileExists(){
        File f = new File(".");
        String FilePath = f.getAbsoluteFile().getParent() + "\\Customers.xml";
        f = new File(FilePath);
        return f.exists();
    }
    //Create an XML file that contains all of the customer info
    public static Document CreateCustomerFile(JFrame mainFrame){
        Document CustomerDoc = null;
        try {
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Build = Factory.newDocumentBuilder();
            CustomerDoc = Build.newDocument();
            Element rootElem = CustomerDoc.createElement("customers");
            CustomerDoc.appendChild(rootElem);
        }
        catch (ParserConfigurationException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Saving The File. Please Restart the Application.");
            System.exit(1);
        }
        return CustomerDoc;
    }
    
    public static Document OpenCustomerFile(JFrame mainFrame){
        Document CustomerDoc = null;
        try {
            File f = new File(".");
            String FilePath = f.getAbsoluteFile().getParent() + "\\Customers.xml";
            f = new File(FilePath);
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Build = Factory.newDocumentBuilder();
            CustomerDoc =  Build.parse(f);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Opening The Customer File. Please Restart the Application.");
            System.exit(1);
        }
        catch (ParserConfigurationException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Opening The Customer File. Please Restart the Application.");
            System.exit(1);
        }
        catch (SAXException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Opening The Customer File. Please Restart the Application.");
            System.exit(1);
        }
        return CustomerDoc;
        
    }
    
    public static void AddPersonal(Document CustomerDoc, PersonalCustomer pCustomer, JFrame mainFrame){
        Element Personal = CustomerDoc.createElement("customer");
        Personal.setAttribute("id", Long.toString(pCustomer.getCustomerID()));
        Personal.setAttribute("type", "personal");
        
        Element TempAttr = CustomerDoc.createElement("name");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getName()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("address");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getCustomerAddress()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("homephone");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getHomePhone()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("workphone");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getWorkPhone()));
        Personal.appendChild(TempAttr);
        
        //Just create the Accounts container
        TempAttr = CustomerDoc.createElement("accounts");
        Personal.appendChild(TempAttr);
        
        //Add the node to the CustomerDoc Root
        CustomerDoc.getDocumentElement().appendChild(Personal);
    }
    
    public static void AddCommercial(Document CustomerDoc, CommercialCustomer cCustomer, JFrame mainFrame){
        Element Personal = CustomerDoc.createElement("customer");
        Personal.setAttribute("id", Long.toString(cCustomer.getCustomerID()));
        Personal.setAttribute("type", "commercial");
        
        Element TempAttr = CustomerDoc.createElement("name");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getName()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("address");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getCustomerAddress()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("contactperson");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getContactPerson()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("contactpersonphone");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getContactPersonPhone()));
        Personal.appendChild(TempAttr);
        
        //Just create the Accounts container
        TempAttr = CustomerDoc.createElement("accounts");
        Personal.appendChild(TempAttr);
        
        //Add the node to the CustomerDoc
        CustomerDoc.appendChild(Personal);
        
    }
    
    private static void CreateAccount(Document CustomerDoc, Account cAccount, JFrame mainFrame){
        //TODO
        Element aElem = CustomerDoc.createElement("account");
        aElem.setAttribute("accoundno", Long.toString(cAccount.getAccountNo()));
        aElem.setAttribute("accountbalance", )
        SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    private static void CreateTransaction(Document CustomerDoc, Transaction t){
        //TODO
    }
    
    private static void SaveCustomerFile(Document CustomerDoc, JFrame mainFrame){
        try {
            TransformerFactory Factory = TransformerFactory.newInstance();
            Transformer Trans = Factory.newTransformer();
            DOMSource source = new DOMSource(CustomerDoc);
            File f = new File(".");
            String FilePath = f.getAbsoluteFile().getParent() + "\\Customers.xml";
            f = new File(FilePath);
            if (f.exists()){
                f.delete();
            }
            StreamResult Result = new StreamResult(f);
            Trans.transform(source, Result);
        }
        catch(TransformerException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Saving The File. Please Restart the Application.");
            System.exit(1);
        }
    }
}

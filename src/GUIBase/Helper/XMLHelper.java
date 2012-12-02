package GUIBase.Helper;

import DataLayer.Account;
import DataLayer.CommercialCustomer;
import DataLayer.Customer;
import DataLayer.PersonalCustomer;
import DataLayer.Transaction;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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
            Element rootElem = CustomerDoc.createElement("Customers");
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
        Element Personal = CustomerDoc.createElement("Customer");
        Personal.setAttribute("Id", Long.toString(pCustomer.getCustomerID()));
        Personal.setAttribute("AccountType", "Personal");
        
        Element TempAttr = CustomerDoc.createElement("name");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getName()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("Address");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getCustomerAddress()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("HomePhone");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getHomePhone()));
        Personal.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("WorkPhone");
        TempAttr.appendChild(CustomerDoc.createTextNode(pCustomer.getWorkPhone()));
        Personal.appendChild(TempAttr);
        
        //Add an account to a created customer
        Element CustomerAccountElem = CreateAccount(CustomerDoc, mainFrame, pCustomer);
        
        //Add the CustomerAccountElement to the Customer element
        Personal.appendChild(CustomerAccountElem);
        
        //Add the node to the CustomerDoc root element ("Customer")
        Element Root = CustomerDoc.getDocumentElement();
        Root.appendChild(Personal);
        
        //Save the entire file
       SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    public static void AddCommercial(Document CustomerDoc, CommercialCustomer cCustomer, JFrame mainFrame){
        Element Commercial = CustomerDoc.createElement("Customer");
        Commercial.setAttribute("Id", Long.toString(cCustomer.getCustomerID()));
        Commercial.setAttribute("AccountType", "Commercial");
        
        Element TempAttr = CustomerDoc.createElement("Name");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getName()));
        Commercial.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("Address");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getCustomerAddress()));
        Commercial.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("ContactPerson");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getContactPerson()));
        Commercial.appendChild(TempAttr);
        
        TempAttr = CustomerDoc.createElement("ContactPersonPhone");
        TempAttr.appendChild(CustomerDoc.createTextNode(cCustomer.getContactPersonPhone()));
        Commercial.appendChild(TempAttr);
        
        //Just create the Accounts container
        TempAttr = CustomerDoc.createElement("Accounts");
        Commercial.appendChild(TempAttr);
        
        //Add an account to a created customer
        Element CustomerAccountElem = CreateAccount(CustomerDoc, mainFrame, cCustomer);
        
        //Add the CustomerAccountElement to the Customer element
        Commercial.appendChild(CustomerAccountElem);
        //Add the node to the CustomerDoc
        CustomerDoc.appendChild(Commercial);
        
        //Save the entire file
        SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    private static Element CreateAccount(Document CustomerDoc, JFrame mainFrame, Customer Cust){
        Account cAccount = new Account();
        Element AccountElem = CustomerDoc.createElement("Account");
        AccountElem.setAttribute("AccoundNo", Long.toString(cAccount.getAccountNo()));
        AccountElem.setAttribute("AccountBalance", Double.toString(cAccount.getAccountBalance()));
        AccountElem.setAttribute("DateOpened", cAccount.getDateOpened());
        if (Cust instanceof CommercialCustomer)
            cAccount.setCommercialInterestRate(Cust);
        AccountElem.setAttribute("InterestRate", Double.toString(cAccount.getInterestRate()));
        Element TransactionElement = CustomerDoc.createElement("Transactions");
        AccountElem.appendChild(TransactionElement);
        return AccountElem;
    }
    
    private static void CreateTransaction(Document CustomerDoc, Transaction t, Account a){
        
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
            Trans.setOutputProperty(OutputKeys.INDENT, "yes");
            Trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Trans.transform(source, Result);
        }
        catch(TransformerException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Saving The File. Please Restart the Application.");
            System.exit(1);
        }
    }
}

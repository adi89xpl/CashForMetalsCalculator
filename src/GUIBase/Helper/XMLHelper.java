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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
        
        Element TempAttr = CustomerDoc.createElement("Name");
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
        
        //Add an account to a created customer
        Element CustomerAccountElem = CreateAccount(CustomerDoc, mainFrame, cCustomer);
        
        //Add the CustomerAccountElement to the Customer element
        Commercial.appendChild(CustomerAccountElem);
        
        //Add the node to the CustomerDoc root element ("Customer")
        Element Root = CustomerDoc.getDocumentElement();
        Root.appendChild(Commercial);
        
        //Save the entire file
       SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    private static Element CreateAccount(Document CustomerDoc, JFrame mainFrame, Customer Cust){
        Account cAccount = new Account();
        Element AccountElem = CustomerDoc.createElement("Account");
        AccountElem.setAttribute("AccountNo", Long.toString(cAccount.getAccountNo()));
        AccountElem.setAttribute("AccountBalance", Double.toString(cAccount.getAccountBalance()));
        AccountElem.setAttribute("DateOpened", cAccount.getDateOpened());
        if (Cust instanceof CommercialCustomer)
            cAccount.setCommercialInterestRate(Cust);
        AccountElem.setAttribute("InterestRate", Double.toString(cAccount.getInterestRate()));
        Element TransactionElement = CustomerDoc.createElement("Transactions");
        AccountElem.appendChild(TransactionElement);
        return AccountElem;
    }
    
    public static void CreateTransaction(JFrame mainFrame, Transaction t, long CustId){
        Document CustomerDoc = OpenCustomerFile(mainFrame);
        Element Tran = CustomerDoc.createElement("Transaction");
        Tran.setAttribute("TransactionId", Core.toString(t.getTransactionID()));
        Tran.setAttribute("TransactionDate", t.getTransactionDate());
        Tran.setAttribute("GoldWeight", Core.toString(t.getGoldWeight()));
        Tran.setAttribute("PlatinumWeight", Core.toString(t.getPlatinumWeight()));
        Tran.setAttribute("SilverWeight", Core.toString(t.getSilverWeight()));
        Tran.setAttribute("TransactionTotal", Core.toString(t.getTransactionTotal()));
        Tran.setAttribute("TransactionType", "Deposit");
        Element Customer = GetCustomer(mainFrame, CustId, CustomerDoc);
        NodeList Transactions = Customer.getElementsByTagName("Transactions");
        for(int i = 0; i < Transactions.getLength(); i++){
            if (Transactions.item(i).getNodeName() == "#text")
                continue;
            Element Current = (Element)Transactions.item(i);
            Current.appendChild(CustomerDoc.importNode(Tran, true));
            break;
        }
        
        NodeList Accounts = Customer.getElementsByTagName("Account");
        for(int i = 0; i < Accounts.getLength(); i++){
            if (Accounts.item(i).getNodeName() == "#text")
                continue;
            Element Current = (Element)Accounts.item(i);
            long AccountId = Core.toLong(Current.getAttribute("AccountNo"));
            String DateOpened = Current.getAttribute("DateOpened");
            double AccountBalance = Core.toDouble(Current.getAttribute("AccountBalance"));
            boolean IsCommercial = false;
            String AccountType = Customer.getAttribute("AccountType");
            if (AccountType.toLowerCase() == "commercial")
                IsCommercial = true;
            Account Acct = new Account(AccountId, AccountBalance, DateOpened, IsCommercial);
            Acct.makeDeposit(t.getGoldWeight(), t.getPlatinumWeight(), t.getGoldWeight());
            Current.setAttribute("AccountBalance", Core.toString(Acct.getAccountBalance()));
            break;
        }
        SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    public static void CreateTransaction(JFrame mainFrame, long CustId, long TransactionId, String TransactionDate, double withdrawAmount){
        Document CustomerDoc = OpenCustomerFile(mainFrame);
        Element Tran = CustomerDoc.createElement("Transaction");
        Tran.setAttribute("TransactionId", Core.toString(TransactionId));
        Tran.setAttribute("TransactionDate", TransactionDate);
        //Tran.setAttribute("GoldWeight", Core.toString(t.getGoldWeight()));
        //Tran.setAttribute("PlatinumWeight", Core.toString(t.getPlatinumWeight()));
        //Tran.setAttribute("SilverWeight", Core.toString(t.getSilverWeight()));
        Tran.setAttribute("TransactionTotal", Core.toString(withdrawAmount));
        Tran.setAttribute("TransactionType", "Withdrawal");
        Element Customer = GetCustomer(mainFrame, CustId, CustomerDoc);
        NodeList Transactions = Customer.getElementsByTagName("Transactions");
        for(int i = 0; i < Transactions.getLength(); i++){
            if (Transactions.item(i).getNodeName() == "#text")
                continue;
            Element Current = (Element)Transactions.item(i);
            Current.appendChild(CustomerDoc.importNode(Tran, true));
            break;
        }
        
        NodeList Accounts = Customer.getElementsByTagName("Account");
        for(int i = 0; i < Accounts.getLength(); i++){
            if (Accounts.item(i).getNodeName() == "#text")
                continue;
            Element Current = (Element)Accounts.item(i);
            long AccountId = Core.toLong(Current.getAttribute("AccountNo"));
            String DateOpened = Current.getAttribute("DateOpened");
            double AccountBalance = Core.toDouble(Current.getAttribute("AccountBalance"));
            boolean IsCommercial = false;
            String AccountType = Customer.getAttribute("AccountType");
            if (AccountType.toLowerCase() == "commercial")
                IsCommercial = true;
            Account Acct = new Account(AccountId, AccountBalance, DateOpened, IsCommercial);
            //Acct.makeDeposit(t.getGoldWeight(), t.getPlatinumWeight(), t.getGoldWeight());
            Acct.makeWithdrawal(withdrawAmount);
            Current.setAttribute("AccountBalance", Core.toString(Acct.getAccountBalance()));
            break;
        }
        SaveCustomerFile(CustomerDoc, mainFrame);
    }
    
    public static long CustomerLookup(JFrame mainFrame, int lookupValue){
        long CustomerId = 0;
        if (CustomerFileExists()){
            Element Root = OpenCustomerFile(mainFrame).getDocumentElement();
            if(Root.hasChildNodes()){
                NodeList Customers = Root.getChildNodes();
                for(int i = 0; i <Customers.getLength(); i++){
                    if (Customers.item(i).getNodeName() == "#text")
                        continue;
                    Element Current = (Element)Customers.item(i);
                    if(lookupValue == Integer.parseInt(Current.getAttribute("Id"))){
                        CustomerId = Integer.parseInt(Current.getAttribute("Id"));
                    }
                }
            }
        }
        return CustomerId;
    } 
    
    public static Element GetCustomer(JFrame mainFrame, long lookupValue, Document CustomerDoc){
        Element Customer = null;
        Element Root = CustomerDoc.getDocumentElement();
        if(Root.hasChildNodes()){
            NodeList Customers = Root.getChildNodes();
            for(int i = 0; i <Customers.getLength(); i++){
                if (Customers.item(i).getNodeName() == "#text")
                    continue;
                Element Current = (Element)Customers.item(i);
                if(lookupValue == Integer.parseInt(Current.getAttribute("Id"))){
                    Customer = Current;
                }
            }
        }
        return Customer;
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
            Trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            Trans.transform(source, Result);
        }
        catch(TransformerException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(mainFrame, "There Was an Error Saving The File. Please Restart the Application.");
            System.exit(1);
        }
    }
    
    public static String getCustomerDisplayData(JFrame mainFrame,long CustomerId){
        StringBuilder sb = new StringBuilder();
        if(CustomerFileExists()){
            Document CustomerDoc = OpenCustomerFile(mainFrame);
            Element Customer = GetCustomer(mainFrame, CustomerId, CustomerDoc);
            GetXMLData(Customer, sb);
        }
        else{
            JOptionPane.showMessageDialog(mainFrame, "The Customer File Does Not Exist.");
            return "";
        }
        return sb.toString();
    }
    
    public static String getCustomerSummaryDisplayData(JFrame mainFrame){
        StringBuilder sb = new StringBuilder();
        if(CustomerFileExists()){
           NodeList Accounts = OpenCustomerFile(mainFrame).getElementsByTagName("Account");
           sb.append("Customer Count: " + Accounts.getLength() + "\n");
           double Total = 0;
           for (int i = 0; i < Accounts.getLength(); i++){
                Node AccountNode = Accounts.item(i);
                if (AccountNode.getNodeName() == "#text")
                    continue;
                Element AccountElem = (Element)AccountNode;
                Total += Core.toDouble(AccountElem.getAttribute("AccountBalance"));
           }
           sb.append("Total Value of All Accounts: " + StringFormatter.formatMoney(Total));
        }
        else{
            JOptionPane.showMessageDialog(mainFrame, "The Customer File Does Not Exist.");
            return "";
        }
        return sb.toString();
    }
    
    private static void GetXMLData(Element Customer, StringBuilder sb){
        DisplayHeader(sb);
        NodeList ns = Customer.getChildNodes();
        sb.append("Customer ID: " + Customer.getAttribute("Id") + "\n");
        sb.append("Customer Type: " + Customer.getAttribute("AccountType") + "\n");
        for (int i = 0; i < ns.getLength(); i++){
            Node Elem = ns.item(i);
            if (Elem.getNodeName() == "#text")
                continue;
            if (Elem.getNodeName() == "Name"){
                sb.append("Customer Name: " + Elem.getTextContent()+ "\n");
                continue;
            }
            if (Elem.getNodeName() == "Address"){
                sb.append("Customer Address: " + Elem.getTextContent() + "\n");
                continue;
            }
            if (Elem.getNodeName() == "HomePhone"){
                sb.append("Customer Home Phone: " + Elem.getTextContent() + "\n");
                continue;
            }   
            if (Elem.getNodeName() == "WorkPhone"){
                sb.append("Customer Work Phone: " + Elem.getTextContent() + "\n");
                continue;
            }
            if (Elem.getNodeName() == "Account"){
                Element AccountElem = (Element)Elem;
                sb.append("Account Number: " + AccountElem.getAttribute("AccountNo") + "\n");
                sb.append("Account Open Date: " + AccountElem.getAttribute("DateOpened") + "\n");
                sb.append("Account Balance: " + StringFormatter.formatMoney(Core.toDouble(AccountElem.getAttribute("AccountBalance"))) + "\n");
                sb.append("Account Interest Rate: " + AccountElem.getAttribute("InterestRate") + "\n");
                NodeList Transactions = AccountElem.getElementsByTagName("Transaction");
                if (Transactions.getLength() > 0){
                    sb.append("\n");
                    sb.append("***********************************\n");
                    sb.append("*********  Transactions  *********\n");
                    sb.append("***********************************\n\n");
                    for (int j = 0; j < Transactions.getLength(); j++){
                        Node Tran = Transactions.item(j);
                        if (Tran.getNodeName() == "#text")
                            continue;
                        Element TranElem = (Element)Tran;
                        sb.append("##### Transaction #####\n");
                        String TranType = TranElem.getAttribute("TransactionType");
                        if (TranType.equalsIgnoreCase("deposit")){
                            sb.append("Transaction Type: Deposit\n" );
                            sb.append("Transaction ID: " + TranElem.getAttribute("TransactionId")+ "\n");
                            sb.append("Transaction Date: " + TranElem.getAttribute("TransactionDate") + "\n");
                            sb.append("Transaction Gold Weight: " + StringFormatter.formatTwoDecimals(Core.toDouble(TranElem.getAttribute("GoldWeight"))) + "\n");
                            sb.append("Transaction Platinum Weight: " + StringFormatter.formatTwoDecimals(Core.toDouble(TranElem.getAttribute("PlatinumWeight"))) + "\n");
                            sb.append("Transaction Silver Weight: " + StringFormatter.formatTwoDecimals(Core.toDouble(TranElem.getAttribute("SilverWeight"))) + "\n");
                            sb.append("Transaction Total: " + StringFormatter.formatMoney(Core.toDouble(TranElem.getAttribute("TransactionTotal"))));
                        }
                        else {
                            sb.append("Transaction Type: Withdrawal\n" );
                            sb.append("Transaction ID: " + TranElem.getAttribute("TransactionId")+ "\n");
                            sb.append("Transaction Date: " + TranElem.getAttribute("TransactionDate") + "\n");
                            sb.append("Transaction Total: " + StringFormatter.formatMoney(Core.toDouble(TranElem.getAttribute("TransactionTotal"))));
                        }
                        if (j != Transactions.getLength() - 1){
                            sb.append("\n\n");
                        }
                    }
                }
                continue;
            }
        }
    }
    
    private static void DisplayHeader(StringBuilder sb){
        sb.append("***********************************\n");
        sb.append("********* Customer Info *********\n");
        sb.append("***********************************\n");
    }
            
}

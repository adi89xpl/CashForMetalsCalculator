package GUIBase.Helper;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class XMLHelper {
    //Check if the file exists
    public static boolean CustomerFileExists(){
        File f = new File(".");
        String FilePath = f.getAbsoluteFile().getParent() + "\\Customers.xml";
        f = new File(FilePath);
        return f.exists();
    }
    //Create an XML file that contains all of the customer info
    public static Document CreateCustomerFile(){
        Document CustomerDoc = null;
        try {
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Build = Factory.newDocumentBuilder();
            
            CustomerDoc = Build.newDocument();
            Element rootElem = CustomerDoc.createElement("customers");
            CustomerDoc.appendChild(rootElem);
        }
        catch (Exception e){
            //TODO
        }
        return CustomerDoc;
    }
    
    public static void AddPersonal(){
        //TODO
    }
    
    public static void AddCommercial(){
        //TODO
    }
    
    public static void SaveFile(){
        //TODO
    }
}

package DataLayer;

import GUIBase.Helper.*;

public class Customer {
    private long CustomerID;
    private String CustomerName;
    private String CustomerAddress;
    
    //Default Constructor
    public Customer(){
        CustomerID = UniqueIDFactory.generateUniqueID();
        CustomerName = "";
        CustomerAddress = "";
    }
    //Overloaded Constructor
    public Customer(String cName){
        CustomerID = UniqueIDFactory.generateUniqueID();
        CustomerName = cName;
        CustomerAddress = "";
    }
    
    //Name Getter
    public String getName(){
        return CustomerName;
    }
    
    //CustomerID Getter
    public Long getCustomerID(){
        return CustomerID;
    }
    //Address Getter & Setter
    public String getCustomerAddress(){
        return CustomerAddress;
    }
    public void setCustomerAddress(String cAddress){
        CustomerAddress = cAddress;
    }
}

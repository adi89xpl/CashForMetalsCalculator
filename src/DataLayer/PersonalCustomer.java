package DataLayer;

public class PersonalCustomer extends Customer {
    private String CustomerHomePhone;
    private String CustomerWorkPhone;
    
    public PersonalCustomer(){
        super();
        CustomerHomePhone = "";
        CustomerWorkPhone = "";
    }
    
    public PersonalCustomer(String cName){
        super(cName);
        CustomerHomePhone = "";
        CustomerWorkPhone = "";
    }
    //HomePhone getter & Setter
    public String getHomePhone(){
        return CustomerHomePhone;
    }
    public void setHomePhone(String cWorkPhone){
        CustomerHomePhone = cWorkPhone;
    }
    //WorkPhone getter & Setter
    public String getWorkPhone(){
        return CustomerWorkPhone;
    }
    public void setWorkPhone(String cWorkPhone){
        CustomerWorkPhone = cWorkPhone;
    }
}

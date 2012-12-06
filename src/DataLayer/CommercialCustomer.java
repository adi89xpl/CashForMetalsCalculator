package DataLayer;

public class CommercialCustomer extends Customer {
    private String ContactPerson;
    private String ContactPersonPhone;
    //default constructor
    public CommercialCustomer(){
        super();
        ContactPerson = "";
        ContactPersonPhone = "";
    }
    //parameterized constructor
    public CommercialCustomer(String cName){
        super(cName);
        ContactPerson = "";
        ContactPersonPhone = "";
    }
    //HomePhone getter & Setter
    public String getContactPerson(){
        return ContactPerson;
    }
    public void setContactPerson(String cHomePhone){
        ContactPerson = cHomePhone;
    }
    //WorkPhone getter & Setter
    public String getContactPersonPhone(){
        return ContactPersonPhone;
    }
    public void setContactPersonPhone(String cHomePhone){
        ContactPersonPhone = cHomePhone;
    }
}

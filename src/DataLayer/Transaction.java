package DataLayer;

import GUIBase.Helper.Constants;
import GUIBase.Helper.UniqueIDFactory;
import java.util.Calendar;

public class Transaction {
    private long TransactionID;
    private Calendar TransactionDate;
    private double goldWeight;
    private double platinumWeight;
    private double silverWeight;
    private double TransactionTotal;
    //Default Constructor
    public Transaction(){
        TransactionID = UniqueIDFactory.generateUniqueID();
        TransactionDate = Calendar.getInstance();
        goldWeight = 0.0;
        platinumWeight = 0.0;
        silverWeight = 0.0;
        TransactionTotal = 0.0;
    }
    //goldWeight Getter & Setter
    public double getGoldWeight(){
        return goldWeight;
    }
    public void setGoldWeight(double gWeight){
        goldWeight = gWeight;
    }
    //platinumWeight Getter & Setter
    public double getPlatinumWeight(){
        return platinumWeight;
    }
    public void setPlatinumWeight(double pWeight){
        platinumWeight = pWeight;
    }
    //silverWeight Getter & Setter
    public double getSilverWeight(){
        return silverWeight;
    }
    public void setSilverWeight(double sWeight){
        silverWeight = sWeight;
    }
    //TransactionTotal Getter
    public double getTransactionTotal(){
        TransactionTotal = (goldWeight * Constants.GOLD_VALUE) + (platinumWeight * Constants.PLATINUM_VALUE) + (silverWeight * Constants.SILVER_VALUE);
        return TransactionTotal;
    }
    public String getTransactionDate(){
        return TransactionDate.get(Calendar.YEAR) + "/" + TransactionDate.get(Calendar.MONTH) + "/" + TransactionDate.get(Calendar.DAY_OF_MONTH);
    }
    public long getTransactionID(){
        return TransactionID;
    }
}

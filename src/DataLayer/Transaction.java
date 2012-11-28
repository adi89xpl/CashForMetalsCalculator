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
    private double getGoldWeight(){
        return goldWeight;
    }
    private void setGoldWeight(double gWeight){
        goldWeight = gWeight;
    }
    //platinumWeight Getter & Setter
    private double getPlatinumWeight(){
        return platinumWeight;
    }
    private void setPlatinumWeight(double pWeight){
        platinumWeight = pWeight;
    }
    //silverWeight Getter & Setter
    private double getSilverWeight(){
        return silverWeight;
    }
    private void setSilverWeight(double sWeight){
        silverWeight = sWeight;
    }
    //TransactionTotal Getter
    private double getTransactionTotal(){
        TransactionTotal = (goldWeight * Constants.GOLD_VALUE) + (platinumWeight * Constants.PLATINU_VALUE) + (silverWeight * Constants.SILVER_VALUE);
        return TransactionTotal;
    }
}

package DataLayer;

import GUIBase.Helper.Constants;
import GUIBase.Helper.UniqueIDFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Account {
    private long AccountNo;
    private double AccountBalance;
    private Calendar DateOpened;
    private double InterestRate;
    //Default Constructor
    public Account(){
        AccountNo = UniqueIDFactory.generateUniqueID();
        AccountBalance = Constants.DEFAULT_ACCOUNT_BALANCE;
        DateOpened = Calendar.getInstance();
        InterestRate = Constants.DEFAULT_INTEREST_RATE;
    }
    //Overloaded Constructor
    public Account(long aId, double aBalance, String dOpened, boolean IsCommercial){
        Date d = new Date();
        try {
            AccountNo = aId;        
            AccountBalance = aBalance;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
            d = (Date)sdf.parse(dOpened);
            DateOpened = Calendar.getInstance();
            DateOpened.setTime(d);
            InterestRate = Constants.DEFAULT_INTEREST_RATE;
            if (IsCommercial)
                InterestRate += 0.03;
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
    }
    //AccountNo Getter
    public long getAccountNo(){
        return AccountNo;
    }
    //AccountBalance Getter
    public double getAccountBalance(){
        return AccountBalance;
    }
    //DateOpened Getter
   public String getDateOpened(){
       return DateOpened.get(Calendar.YEAR) + "/" + DateOpened.get(Calendar.MONTH) + "/" + DateOpened.get(Calendar.DAY_OF_MONTH);
   }
    //InterestRate Getter
    public double getInterestRate(){
        return InterestRate;
    }
    //makeDeposit Method
    public void makeDeposit(double gWeight, double pWeight, double sWeight){
        double goldTotal = gWeight * Constants.GOLD_VALUE;
        double platinumTotal = pWeight * Constants.PLATINUM_VALUE;
        double silverTotal = sWeight * Constants.SILVER_VALUE;
        double depositTotal = goldTotal + platinumTotal + silverTotal;
        depositTotal *= (1 + InterestRate);
        AccountBalance += depositTotal;
    }
    //makeWithdrawal Method
    public double makeWithdrawal(double withdrawAmount){
        if (withdrawAmount > 0.0){
            if (AccountBalance - withdrawAmount > 0.0){
                AccountBalance -= withdrawAmount;
                return withdrawAmount;
            }
        }
        return 0.0;
    }
    
    //Set the new account interst rate only of the customer in commercial customer
    public void setCommercialInterestRate(Customer c){
        if(c instanceof CommercialCustomer){
            setInterestRate();
        }
    }
    private void setInterestRate(){
        InterestRate += 0.03;
    }
}

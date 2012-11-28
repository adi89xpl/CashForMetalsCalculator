package DataLayer;

import GUIBase.Helper.Constants;
import GUIBase.Helper.UniqueIDFactory;
import java.util.Calendar;

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
    //AccountNo Getter
    public long getAccountNo(){
        return AccountNo;
    }
    //AccountBalance Getter
    public double getAccountBalance(){
        return AccountBalance;
    }
    //DateOpened Getter
    public Calendar getDateOpened(){
        return DateOpened;
    }
    //InterestRate Getter
    public double getInterestRate(){
        return InterestRate;
    }
    //makeDeposit Method
    public void makeDeposit(double gWeight, double pWeight, double sWeight){
        
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
}

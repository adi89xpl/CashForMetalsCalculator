package GUIBase.Helper;

import java.util.Calendar;

//This class is used to generate unique IDs
public class UniqueIDFactory {
    public static long generateUniqueID(){
        return Calendar.getInstance().getTimeInMillis()/1000;
    }
    
}

package GUIBase.Helper;

import java.util.Calendar;

public class UniqueIDFactory {
    public static long generateUniqueID(){
        return Calendar.getInstance().getTimeInMillis()/1000;
    }
    
}

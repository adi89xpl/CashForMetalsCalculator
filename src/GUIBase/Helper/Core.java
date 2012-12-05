package GUIBase.Helper;

import java.util.Calendar;

public final class Core {
    public static boolean IsNumeric(String val){
        try {
            Double.parseDouble(val);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
    public static double toDouble(String val){
        double retVal = 0.0;
        try {
            retVal = Double.parseDouble(val);
        }
        catch (NumberFormatException ex){
           //Do Nothing - 0.0 will be returned anyhow
        }
       return retVal;
    }
    public static String toString(Object val){
        return String.valueOf(val);
    }
    public static long toLong(String val){
        return Long.parseLong(val);
    }
}

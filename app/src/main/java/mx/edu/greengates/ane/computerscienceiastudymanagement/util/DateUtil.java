package mx.edu.greengates.ane.computerscienceiastudymanagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getDate(String date) {
        Date newDate;
        try {
            newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
            newDate = new Date();
        }
        return newDate;
    }

    public static Date getDate(String date, String pattern) {
        Date newDate;
        try {
            newDate = new SimpleDateFormat(pattern).parse(date);
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
            newDate = new Date();
        }
        return newDate;
    }


    public static String setDate(Date date){

        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}

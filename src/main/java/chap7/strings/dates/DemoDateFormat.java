package chap7.strings.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Stas on 10/01/2015.
 */
public class DemoDateFormat {

    public static void main(String[] args) {


        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        Date d = null;
        String str = "April 9, 2012";
        try{
            d = df.parse(str);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df = DateFormat.getDateInstance(DateFormat.LONG,new Locale("ru","RU"));
        System.out.println(df.format(d));
        df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
        System.out.println(df.format(d));
    }
}

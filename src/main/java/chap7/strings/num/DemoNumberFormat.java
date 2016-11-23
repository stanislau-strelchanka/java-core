package chap7.strings.num;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Stas on 10/01/2015.
 */
public class DemoNumberFormat {

    public static void main(String[] args) {

        NumberFormat nfGe = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat nfUs = NumberFormat.getInstance(Locale.US);
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);

        double iGe = 0, iUs = 0, iFr = 0;
        String str = "1.234,5";
        try{

            iGe = nfGe.parse(str).doubleValue();
            iUs = nfUs.parse(str).doubleValue();
            iFr = nfFr.parse(str).doubleValue();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.printf("iGe = %f\niUs = %f\niFr = %f", iGe, iUs, iFr);

        String sUs = nfUs.format(iGe);
        String sFr = nfFr.format(iGe);

        System.out.println("\nUs " + sUs + "\nFr " + sFr);

    }
}

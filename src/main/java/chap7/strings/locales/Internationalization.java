package chap7.strings.locales;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Stas on 10/01/2015.
 */
public class Internationalization {

    public static void main(String[] args) {

        System.out.println("1 - english\n 2 - russian");
        char i = 0;
        try{
            i = (char) System.in.read();
            String country = "";
            String language = "";
            if (i == '1') {
                country = "US";
                language = "en";
            }else{
                country = "RU";
                language = "ru";
            }
            Locale locale = new Locale(language, country);
            ResourceBundle bundle = ResourceBundle.getBundle("chap7/text", locale);
            String string = bundle.getString("label.button");
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package chap7.strings.locales;

import java.util.Locale;

/**
 * Created by Stas on 10/01/2015.
 */
public class DemoLocales {

    public static void main(String[] args) {

        Locale belarus = new Locale("be","BY");
        show(belarus);
        Locale def = Locale.getDefault();
        show(def);
    }

    private static void show(Locale locale) {
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayLanguage());
    }
}

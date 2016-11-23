package chap7.strings.locales;

import java.util.Locale;

/**
 * Created by Stas on 10/01/2015.
 */
public class ResourceManagerRun {

    public static void main(String[] args) {

        ResourceManager manager = ResourceManager.INSTANCE;
        System.out.println(manager.getString("label.button"));
        manager.changeResource(new Locale("ru","RU"));
        System.out.println(manager.getString("label.button"));
    }
}

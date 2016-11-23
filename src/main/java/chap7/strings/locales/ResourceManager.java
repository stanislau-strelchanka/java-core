package chap7.strings.locales;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Stas on 10/01/2015.
 */
public enum ResourceManager {

    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "chap7/text";
    private ResourceManager(){

        resourceBundle = ResourceBundle.getBundle(resourceName,new Locale("en","US"));
    }

    public void changeResource(Locale locale){

        resourceBundle = ResourceBundle.getBundle(resourceName,locale);
    }

    public String getString(String key){

        return resourceBundle.getString(key);

    }
}

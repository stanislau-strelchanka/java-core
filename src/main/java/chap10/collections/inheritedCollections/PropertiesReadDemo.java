package chap10.collections.inheritedCollections;

import helpers.Helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Stas on 12/01/2015.
 */
public class PropertiesReadDemo {

    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            // загрузка пар ключ-значение через поток ввода-вывода
            props.load(new FileReader(Helper.PATH10 + "database.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
        String driver = props.getProperty("db.driver");
        String driver2 = props.getProperty("db.driver","new driver name");// т.к уже существует
        // следующих двух ключей в файле нет
        String maxIdle = props.getProperty("db.maxIdle"); // будет присвоен null
        // значение "20" будет присвоено ключу, если он не будет найден в файле
        String maxActive = props.getProperty("db.maxActive", "20");
        System.out.println(driver);
        System.out.println(driver2);
        System.out.println(maxIdle);
        System.out.println(maxActive);

    }
}

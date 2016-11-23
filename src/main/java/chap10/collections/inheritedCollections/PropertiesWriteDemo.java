package chap10.collections.inheritedCollections;



import helpers.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Stas on 12/01/2015.
 */
public class PropertiesWriteDemo {

    public static void main(String[] args) {

        Properties props = new Properties();

        try{

            props.setProperty("db.driver", "com.mysql.jdbc.Driver");
            // props.setProperty("db.url", "jdbc:mysql://127.0.0.1:3306/testphones");
            props.setProperty("db.user", "root");
            props.setProperty("db.password", "pass");
            props.setProperty("db.poolsize", "5");
            // запись properties-файла в папку prop проекта
            props.store(new FileWriter(Helper.PATH10 + "database.properties"),null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

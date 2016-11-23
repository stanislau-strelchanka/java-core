package chap13.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Stas on 23/02/2015.
 */
public class UrlDemo {

    public static void main(String[] args) throws IOException {

        URL bsu = new URL("http://www.bsu.by");
        BufferedReader reader = new BufferedReader(new InputStreamReader(bsu.openStream()));
        String line = "";
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }

        URL oracle = new URL("http://www.oracle.com");
        URLConnection oracleConnection = oracle.openConnection();
        oracleConnection.setReadTimeout(10000);
        oracleConnection.setConnectTimeout(10000);
        System.out.println("\n" +
                "Oracle content type \n"+oracleConnection.getContentType());

    }
}

package chap3.classesobjects.classloader.itf;

import helpers.Helper;

import java.net.URL;
import java.net.URLClassLoader;

import static java.io.File.separator;

/**
 * Created by kevinj.
 */

//don't change package name, as it is binded in chap3 jar folder.... yeap, smells bad
//or rebuild Quote (first implement it) than put there updated
public class Main {

    public static final String QUOTE = "chap3.classesobjects.classloader.itf.Quote";

    public static void main(String[] args) throws Exception {
        String uri = getUri();

        URL url1 = new URL(uri);
        URLClassLoader ucl1 = new URLClassLoader(new URL[]{url1});
        Class clazz1 = Class.forName(QUOTE, true, ucl1);
        //this iQuote loaded by app cll
        IQuote quote1 = (IQuote) clazz1.newInstance();

        URL url2 = new URL(uri);
        URLClassLoader ucl2 = new URLClassLoader(new URL[]{url2});
        Class clazz2 = Class.forName(QUOTE, true, ucl2);
        IQuote quote2 = (IQuote) clazz2.newInstance();

        System.out.printf("clazz1 == clazz2? %b\n", clazz1 == clazz2);
        System.out.printf("quote1.class == quote2.class? %b\n", quote1.getClass() == quote2.getClass());

        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz2.getClassLoader());
    }

    private static String getUri() {
        return "file:///" + Helper.PATH3_CL
                .concat(separator).concat("itf")
                .concat(separator).concat("Implementations.jar");
    }
}

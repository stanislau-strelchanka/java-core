package chap3.classesobjects.classloader.simple;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import static java.io.File.separator;

public class Main {

    public static String PATH = "D:\\Other\\projects\\JAVA\\HomeProjects\\Blinnov\\Java-core\\src\\main\\" +
            "resources\\chap3\\Quoter.jar";

    public static void main(String[] args) {
        URL url;
        try {
            String path = getPath();
            url = new URL("file:///" + path);
            URLClassLoader ucl = new URLClassLoader(new URL[]{url});
            Class<?> clazz = ucl.loadClass("com.mantiso.Quote");
            Object o = clazz.newInstance();
            System.out.println(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir")
                .concat(separator).concat("src")
                .concat(separator).concat("main")
                .concat(separator).concat("resources")
                .concat(separator).concat("chap3")
                .concat(separator).concat("simple")
                .concat(separator).concat("Quoter.jar");
    }
}

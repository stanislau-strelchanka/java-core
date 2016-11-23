package helpers;

import static java.io.File.*;

public class Helper {

    private static final String PATH = System.getProperty("user.dir") + separator + "src" +
            separator + "main" + separator + "resources" + separator;

    public static final String PATH3_CL = createPath("chap3" + separator + "classloader");
    public static final String PATH9 = createPath("chap9");
    public static final String PATH10 = createPath("chap10");
    public static final String PATH11 = createPath("chap11");
    public static final String PATH13 = createPath("chap13");
    public static final String PATH14 = createPath("chap14");

    private static String createPath(String core) {
        return PATH + core + separator;
    }
}
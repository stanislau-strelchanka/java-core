package chap3.classesobjects.classloader.dynamic;

import java.net.URL;
import java.net.URLClassLoader;

public class Factory {

    public static Counter newInstance() throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{getClassPath()}) {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if ("chap3.classesobjects.classloader.dynamic.CounterImpl".equals(name)) {
                    return findClass(name);
                }
                return super.loadClass(name);
            }
        };
        return (Counter) classLoader.loadClass("chap3.classesobjects.classloader.dynamic.CounterImpl").newInstance();
    }

    private static URL getClassPath() {
        return Factory.class.getResource("");
    }
}

package chap3.classesobjects.classloader;

import helpers.Helper;

import java.io.*;


public class MyChildFirstFromResFolderClassloader extends ClassLoader {

    private final String dirPath;

    public MyChildFirstFromResFolderClassloader(String dir) {
        super(getSystemClassLoader());
        this.dirPath = Helper.PATH3_CL + dir;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> aClass = findClass(name);
        return aClass == null ? super.loadClass(name) : aClass;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File(dirPath, getFileName(name) + ".class")));

            ByteArrayOutputStream lOutput = new ByteArrayOutputStream();
            int i = 0;
            while ((i = is.read()) >= 0) {
                lOutput.write(i);
            }
            byte[] bytes = lOutput.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            return null;
        }
    }

    private String getFileName(String fullClassName) {
        String[] split = fullClassName.split("\\.");
        return split[split.length - 1];
    }
}

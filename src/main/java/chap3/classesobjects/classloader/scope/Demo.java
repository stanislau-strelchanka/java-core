package chap3.classesobjects.classloader.scope;


import chap3.classesobjects.classloader.MyChildFirstFromResFolderClassloader;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Purpose is to test how class loaders are binded to classes
 */
public class Demo {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = new MyChildFirstFromResFolderClassloader("scope");
        Factory appFactory = new FactoryImpl();
        Class<?> factoryClass = classLoader.loadClass("chap3.classesobjects.classloader.scope.FactoryImpl");
        Factory cutomCLFactory = (Factory)factoryClass.newInstance();

        Int appCLInt = appFactory.create();
        Int customCLInt = cutomCLFactory.create();

        IntImpl appCLImpl = (IntImpl) appCLInt;

        //trows exception as this impl was created with another class loader
        try {
            IntImpl customCLImpl = (IntImpl) customCLInt;
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}

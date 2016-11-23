package chap3.classesobjects.classloader.scope;

public class FactoryImpl implements Factory {
    public Int create() {
        IntImpl impl = new IntImpl();
        System.out.println("Instance created using " + impl.getClass().getClassLoader() + " class loader ");
        return impl;
    }
}

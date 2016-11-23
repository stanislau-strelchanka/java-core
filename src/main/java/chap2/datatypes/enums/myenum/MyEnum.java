package chap2.datatypes.enums.myenum;

/**
 * Created by Stas on 12/01/2015.
 */
public abstract class MyEnum<T extends MyEnum<T>> {

    public abstract T values();
    public abstract T valueOf(String name);
}

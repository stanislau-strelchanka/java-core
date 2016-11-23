package chap2.datatypes.enums.foobar;

/**
 * Created by Stas on 12/01/2015.
 */
abstract public class Foo<T extends Foo<T>> { //only for direct subclasses, not for the whole tree

    public abstract T subclassAwareDeepCopy();
}

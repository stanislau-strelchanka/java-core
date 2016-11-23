package chap2.datatypes.enums.foobar;

/**
 * Created by Stas on 12/01/2015.
 */
public class Bar extends Foo<Bar> {

    @Override
    public Bar subclassAwareDeepCopy() {

        return new Bar();
    }
}

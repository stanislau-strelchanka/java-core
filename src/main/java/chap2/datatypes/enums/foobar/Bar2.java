package chap2.datatypes.enums.foobar;

/**
 * Created by Stas on 12/01/2015.
 */
public class Bar2 extends Foo2<Bar2>{

    @Override
    public Bar2 subclassAwareDeepCopy() {
        return new Bar2();
    }

}

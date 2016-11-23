package chap10.collections.generics.wildcards.copyable;

/**
 * Created by Stas on 11/01/2015.
 */
public class Person implements Copyable<Person> {

    @Override
    public Person produceMyCopy() {
        return new Person();
    }

}

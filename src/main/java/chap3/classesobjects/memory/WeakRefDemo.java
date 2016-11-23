package chap3.classesobjects.memory;

import java.lang.ref.WeakReference;

/**
 * Created by stacy on 17.4.16.
 */
public class WeakRefDemo {

    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> wr = new WeakReference<Person>(person);

        Person person2 = wr.get();
        System.out.println(person);
        System.out.println(person2);

        person = null;
        System.gc();

        System.out.println("One reference exists");
        System.out.println(wr.get());

        person2 = null;
        System.gc();

        System.out.println("No reference exists");
        System.out.println(wr.get());
    }

    private static class Person {

    }
}

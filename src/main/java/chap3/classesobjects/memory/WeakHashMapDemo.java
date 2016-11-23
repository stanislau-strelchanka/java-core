package chap3.classesobjects.memory;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.WeakHashMap;

/**
 * Created by stacy on 18.4.16.
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap weakHashMap = new WeakHashMap<Person, PersonMetaData>();

        Person person = new Person();
        WeakReference<Person> weakPerson = new WeakReference<Person>(person);
        weakHashMap.put(person, new PersonMetaData());

        System.out.println("Person is not null");
        System.out.println(weakHashMap.get(person));


        PersonMetaData metaData = (PersonMetaData) weakHashMap.get(person);
        person = null;

        System.out.println("Person is null");
        System.out.println(weakHashMap.get(weakPerson.get()));
        System.out.println("Contains meta data? " + weakHashMap.containsValue(metaData));

        System.out.println("After garbage collection");
        System.gc();
        System.out.println(weakHashMap.get(weakPerson.get()));

        System.out.println("Contains meta data? " + weakHashMap.containsValue(metaData));
    }

    static final class Person {

    }

    static class PersonMetaData {

        Date date;

        PersonMetaData() {
            date = new Date();
        }

        @Override
        public String toString() {
            return "PersonMetaDate date: " + date;
        }
    }
}

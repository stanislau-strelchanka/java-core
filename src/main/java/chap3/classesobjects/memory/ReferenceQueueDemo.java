package chap3.classesobjects.memory;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by stacy on 18.4.16.
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        final ReferenceQueue<Person> refQueue = new ReferenceQueue<Person>();
        Person person = new Person();
        new PersonWeakReference(person, new PersonCleaner(), refQueue);


        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    PersonWeakReference poll = (PersonWeakReference) refQueue.poll();
                    if (poll != null) {
                        poll.clear();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.run();

        System.out.println("Using person");
        Thread.sleep(10);

        System.out.println("All references removed");
        person = null;


    }

    static final class Person {

    }

    static class PersonCleaner {

        public void clear(){
            System.out.println("Cleaned");
        }
    }

    static class PersonWeakReference extends WeakReference<Person> {

        private PersonCleaner personCleaner;

        public void clear() {
            personCleaner.clear();
        }

        public PersonWeakReference(Person referent, PersonCleaner personCleaner, ReferenceQueue<? super Person> q) {
            super(referent, q);
        }
    }

}

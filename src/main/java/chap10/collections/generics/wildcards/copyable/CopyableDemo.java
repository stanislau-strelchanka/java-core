package chap10.collections.generics.wildcards.copyable;

import java.util.LinkedList;

/**
 * Created by Stas on 11/01/2015.
 */
public class CopyableDemo {

    public static void main(String[] args) {

        LinkedList<?> list1 = new LinkedList<String>()
        {
            {add("1");add("2");add("3");}
        };
        Class<? extends LinkedList> aClass = list1.getClass();
        Object first = list1.getFirst();
        list1.add(null);
        for (Object o : list1) {
            System.out.println(o);
        }

        Person person = new Employee();
        Employee employee = new Employee();

        produceCopy(person);
        produceCopy(employee);
        produceCopy2(person);
        //produceCopy2(employee); as emploee of type Copyable<Person>, not Copyable<Employee>
        someMethod(person,person); //ok
        //someMethod(employee,employee); not ok
        someMethod2(person,person);
        someMethod2(employee,employee);

    }

    static <T extends Copyable<? super T>> T produceCopy(T arg){
        Object copy = arg.produceMyCopy();//drawback as it returns object
        return arg;
    }
    static <T extends Copyable<? extends T>> T produceCopy2(T arg){
        Object copy = arg.produceMyCopy();
        return arg;
    }
    static <T extends Copyable<T>> void someMethod(T arg1,T arg2){

    }
    static <T extends Copyable<? super T>> void someMethod2(T arg1,T arg2){
    }
}

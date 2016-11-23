package chap10.collections.generics.wildcards.copyable;

/**
 * Created by Stas on 11/01/2015.
 */
public class Employee extends Person implements Copyable<Person>{ //implements Copyable<Employee> not allowed

    @Override
    public Employee produceMyCopy(){
        return  new Employee();
    }
}

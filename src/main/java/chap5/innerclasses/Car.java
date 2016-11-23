package chap5.innerclasses;

import java.util.ArrayList;

/**
 * Created by Stas on 14/01/2015.
 */
public class Car {

    public int carField;

    public class Person extends ArrayList{ //inner

        public int personField;
        //static int personField2; inner classes cannot have static fields, except final static
        static final int getPersonField3 = 3;

        public void method2(){

            Car.this.method2(); // access from inner class to its outter class refference !!!
            method2();// recursion method
        }
    }

    static public class Person2{ // nested

        public int personField;
        static int personField2;
        static final int getPersonField3 = 3;

        public void method(){

            // cannot access from nested class to its outter class reference!!!
            //Car.this.method2();
        }
    }

    public void method2(){

        final int i = 5;
        int j = 5;

        IShip iShip = new IShip() {
            public void method() {
                carField++;//has access to outter class members
                int b = i;
                //j++; cannot modify local variables, need to be final
            }
        };
    }

    public static void main(String[] args) {

        Car.Person p = new Car().new Person();
        Car.Person2 p2 = new Car.Person2();
    }

    private interface IShip {

        public void method();
    }
}

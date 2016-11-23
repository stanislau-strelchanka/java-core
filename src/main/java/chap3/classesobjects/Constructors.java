package chap3.classesobjects;

public class Constructors {

    public class A {
        A(String argA) {

        }
    }

    public class B extends A {
        /*B() { As you need to execute parents consturctor

        }*/

        public B(String argA) {
            super(argA); // mandatory
        }
    }
}

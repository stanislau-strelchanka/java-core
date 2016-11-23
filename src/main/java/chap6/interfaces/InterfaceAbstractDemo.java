package chap6.interfaces;

/**
 * Created by Stas on 22/01/2015.
 */
public class InterfaceAbstractDemo {

    interface A{
        public int B = 5;//static final always
        void a();
        void b();
        void c();
        void d();
    }

    abstract class B implements A{ // abstract class can provide partial implementation
        // can have constructors, static, final fields, non abstract
        public void a(){
            System.out.println("I am a");
        }
    }

    class C extends B{

        @Override
        public void b() {

            System.out.println("I am B");
        }

        @Override
        public void c() {

            System.out.println("I am C");
        }

        @Override
        public void d() {

            System.out.println("I am D");
        }
    }

    public static void main(String[] args) {

        C c = new InterfaceAbstractDemo().new C();
        c.a();
    }

}

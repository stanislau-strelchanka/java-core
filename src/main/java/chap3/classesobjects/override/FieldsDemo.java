package chap3.classesobjects.override;

/**
 * Created by Stas on 22/01/2015.
 */
public class FieldsDemo {

    class A{
        int a = 5;
        int getA(){
            return a;
        }
    }

    class B extends A{
        int a = 7;
        int getA(){
            return a;
        }
    }

    public static void main(String[] args) {

        A b = new FieldsDemo().new B();

        System.out.println(b.a);//5 as fields does not support dynamic binding
        System.out.println(b.getA());//7
    }
}

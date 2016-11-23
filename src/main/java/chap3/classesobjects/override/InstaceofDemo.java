package chap3.classesobjects.override;

/**
 * Created by Stas on 22/01/2015.
 */
public class InstaceofDemo {

    class A{

    }

    class B extends A{

    }

    public static void main(String[] args) {
        A b = new InstaceofDemo().new B();
        B bb = new InstaceofDemo().new B();
        System.out.println(b instanceof A);//true
        System.out.println(b instanceof B);//true
        System.out.println(bb instanceof A);//true
        b = null;
        System.out.println(b instanceof A);//false
        System.out.println(b instanceof B);//false
    }
}

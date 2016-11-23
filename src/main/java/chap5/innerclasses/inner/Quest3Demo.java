package chap5.innerclasses.inner;

/**
 * Created by Stas on 31/03/2015.
 */
public class Quest3Demo {

    public static void main(String[] args) {
        Outer obj = new Outer().new Inner1();
        Outer.Inner2 obj2 = new Outer().new Inner2();
        obj.print();
        obj2.print();
    }
}

class Outer {
    public void print() {
    }
    class Inner1 extends Outer{
        public void print() {
            System.out.println("In inner.");
        }
    }

    class Inner2{
        public void print(){
            System.out.println("In inner 2.");
        }
    }
}


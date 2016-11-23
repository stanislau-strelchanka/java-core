package chap3.classesobjects.override;


public class OverrideDemo {

    class A{

        A get(){

            System.out.println("From class A");
            return this;
        };
    }

    class B extends A{

        public void message(){
            System.out.println("from class B");
        }

        @Override
        B get(){
            System.out.println("From class B");
            return this;
        }
    }

    public static void main(String[] args) {

        A b = new OverrideDemo().new B();
        System.out.println(b.get().getClass().getSimpleName());

    }

    public void tryCreate(){

        A b = new B();
        b.get();
    }
}

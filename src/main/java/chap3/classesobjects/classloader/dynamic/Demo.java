package chap3.classesobjects.classloader.dynamic;

//todo fix it
public class Demo {

    public static void main(String[] args) throws Exception {
        Counter counter1 = Factory.newInstance();

        while (true) {
            Counter counter2 = Factory.newInstance();

            System.out.println("counter 1" + counter1.message() + " " + counter1.counter());
            System.out.println("counter 2" + counter2.message() + " " + counter2.counter());
        }
    }
}

package chap3.classesobjects.override;

/**
 * Created by Stas on 22/01/2015.
 */
public class SuperThisDemo {

    class Wheel{

        Wheel(){
            System.out.println("Wheel is created");
        }
    }

    class Vehicle extends Wheel{
        int param = 4;
        Vehicle(){
            System.out.println("Vehicle is created");
        }
        Vehicle(int param){
            System.out.println("Vehicle with params");
        }
    }

    class Bike extends Vehicle{
        int param = 5;
        Bike(){
            this(3);
//            super(3); need to be in the beginning as "this"
            System.out.println("Bike is created");
//            this(3); need to put to the beginning
            System.out.println("Super param " + super.param);
        }
        Bike(int param){

            System.out.println("Bike with param is created " + param);
        }
    }

    public static void main(String[] args) {

        Wheel v = new SuperThisDemo().new Bike();
    }
}

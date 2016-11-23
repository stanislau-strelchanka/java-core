package chap3.classesobjects.overload;

/**
 * Created by Stas on 14/01/2015.
 */
public class StaticOverloadDemo {

    public static void main(String[] args) {

        Car.show();
        Car.show2();
        SuperCar.show();
        SuperCar.show2();

        Car car = new SuperCar();
        car.show();
    }
}

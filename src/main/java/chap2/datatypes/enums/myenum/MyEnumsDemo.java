package chap2.datatypes.enums.myenum;

/**
 * Created by Stas on 12/01/2015.
 */
public class MyEnumsDemo {

    public static void main(String[] args) {

        TrafficLightState amber = TrafficLightState.AMBER;
        System.out.println(amber);
        amber = amber.next();
        System.out.println(amber);
        amber = amber.next();
        System.out.println(amber);
        TrafficLightState green = TrafficLightState.GREEN;
        System.out.println(TrafficLightState.AMBER.compareTo(green));
        System.out.println(green.getDeclaringClass());
        MyTrafficLightState red = MyTrafficLightState.RED;
    }
}

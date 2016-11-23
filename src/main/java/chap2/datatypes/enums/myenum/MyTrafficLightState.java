package chap2.datatypes.enums.myenum;

/**
 * Created by Stas on 12/01/2015.
 */
public abstract class MyTrafficLightState extends MyEnum<MyTrafficLightState> {

//    private MyTrafficLightState(){
//
//    }

    public static final MyTrafficLightState RED = new MyTrafficLightState(){

        @Override
        public MyTrafficLightState next() {
            return AMBER;
        }
    };
    public static final MyTrafficLightState AMBER = new MyTrafficLightState(){

        @Override
        public MyTrafficLightState next() {
            return GREEN;
        }
    };
    public static final MyTrafficLightState GREEN = new MyTrafficLightState(){

        @Override
        public MyTrafficLightState next() {
            return RED;
        }
    };

    @Override
    public MyTrafficLightState values() {
        return null;
    }

    @Override
    public MyTrafficLightState valueOf(String name) {
        return null;
    }

    public abstract MyTrafficLightState next();
}

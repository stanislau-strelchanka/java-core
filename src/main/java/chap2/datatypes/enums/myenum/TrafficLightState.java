package chap2.datatypes.enums.myenum;

/**
 * Created by Stas on 12/01/2015.
 */
public enum TrafficLightState {

    GREEN(20){
        @Override
        public TrafficLightState next() {
            return AMBER;
        }
    },
    AMBER(10){
        @Override
        public TrafficLightState next() {
            return RED;
        }
    },
    RED(30){
        @Override
        public TrafficLightState next() {
            return GREEN;
        }
    };

    private final int duration;

    private TrafficLightState(int duration){

        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    public abstract TrafficLightState next();
}

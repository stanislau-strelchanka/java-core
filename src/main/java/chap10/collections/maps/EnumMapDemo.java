package chap10.collections.maps;

import java.util.EnumMap;

/**
 * Created by Stas on 12/01/2015.
 */
public class EnumMapDemo {

    enum GASStation{

        DT(50),A80(30),A92(30),A95(50),GAS(40);

        private Integer maxVolume;
        private GASStation(int maxVolume){
            this.maxVolume = maxVolume;
        }

        public Integer getMaxVolume(){

            return maxVolume;
        }
    }

    public static void main(String[] args) {

        EnumMap<GASStation, Integer> station1 =
                new EnumMap<GASStation, Integer>(GASStation.class);
        station1.put(GASStation.DT, 10);
        station1.put(GASStation.A80, 5);
        station1.put(GASStation.A92, 30);
        EnumMap<GASStation, Integer> station2 =
                new EnumMap<GASStation, Integer>(GASStation.class);
        station2.put(GASStation.DT, 25);
        station2.put(GASStation.A95, 25);
        System.out.println(station1);
        System.out.println(station2);
    }


}


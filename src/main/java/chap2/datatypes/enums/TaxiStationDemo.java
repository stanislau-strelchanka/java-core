package chap2.datatypes.enums;

/**
 * Created by Stas on 11/01/2015.
 */
public class TaxiStationDemo {

    public static void main(String[] args) {

        TaxiStation taxiStation = TaxiStation.values()[0];//get by ordinal
        System.out.println(taxiStation);
        TaxiStation ts = TaxiStation.valueOf(TaxiStation.class,"Volvo".toUpperCase());
        System.out.println(ts + " : ordinal -> " + ts.ordinal());
        ts.setFreeCabes(3);
        TaxiStation tx2 = TaxiStation.VOLVO;
        tx2.setFreeCabes(199);
        TaxiStation[ ] station = TaxiStation.values();
        for (TaxiStation element : station) {
            System.out.println(element + " ->" + element.ordinal());
        }
    }
}

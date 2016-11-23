package chap10.collections.sets;

import chap10.collections.items.CarManufacturer;

import java.util.EnumSet;

/**
 * Created by Stas on 12/01/2015.
 */

public class EnumSetDemo {

    public static void main(String[] args) {

        EnumSet<CarManufacturer> japanAuto = EnumSet.range(CarManufacturer.TOYOTA,CarManufacturer.SUZUKI);
        EnumSet<CarManufacturer> carManufacturers = EnumSet.complementOf(japanAuto);

        System.out.println(japanAuto);
        System.out.println(carManufacturers);
        action("audi",japanAuto);
        action("suzuki",japanAuto);

        System.out.println(japanAuto);
        System.out.println(carManufacturers);
    }

    public static boolean action(String auto, EnumSet<CarManufacturer> set){

        CarManufacturer cm = CarManufacturer.valueOf(auto.toUpperCase());
        boolean ok = false;

        if(ok = set.contains(cm)){
            System.out.println("обработан: " + cm);
        }
        else{
            System.out.println("Обработка невозможна: " + cm);
        }
        return ok;
    }
}

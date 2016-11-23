package chap2.datatypes.enums;

/**
 * Created by stst on 30.12.2014.
 */
public enum TaxiStation {

    MERCEDES(10),TOYOTA(7),VOLVO;

    private int freeCabs;

    TaxiStation(){

    }

    TaxiStation(int cabs){

        freeCabs = cabs;
    }

    public int getFreeCabes(){

        return freeCabs;
    }

    public void setFreeCabes(int cabs){

        freeCabs = cabs;
    }

    @Override
    public String toString() {
        return String.format("%s : free cabs = %d", name(), freeCabs);
    }

}


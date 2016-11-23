package chap11.threads.immutability;

/**
 * Created by Stas on 15/01/2015.
 */
public class ImmutableValue {

    private int value;

    public ImmutableValue(int value){
        this.value = value;
    }

    public int getValue(){

        return value;
    }

    public ImmutableValue add(int value){

        return new ImmutableValue(this.value + value);
    }
}

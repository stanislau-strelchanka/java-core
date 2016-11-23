package chap11.threads.immutability;

/**
 * Created by Stas on 15/01/2015.
 */
public  class Calculator //not thread-safe
                        //methods need to be synchronized
                        {

    private ImmutableValue value = null;

    public ImmutableValue getValue(){
        return value;
    }

    public void setValue(ImmutableValue value){
        this.value = value;
    }

    public void add(int value){

        System.out.println("Before add " + this.value);
        this.value = this.value.add(value);
        System.out.println("After add " + this.value);
    }
}

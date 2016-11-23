package chap3.classesobjects.classloader.dynamic;

public class CounterImpl implements Counter{

    private int counter;

    public String message() {
        return "Version 1";
    }

    public int plusPlus() {
        return counter++;
    }

    public int counter() {
        return counter;
    }
}

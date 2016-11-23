package chap10.collections.items;

import java.util.ArrayList;

public class IterableOrder2 extends ArrayList<Item> {
    private int orderId;
    // private float amount; // по прежнему не нужен, т.к. сумму можно вычислить
    public IterableOrder2(ArrayList<Item> c) {
        super(c);
    }
    public IterableOrder2(int orderId, ArrayList<? extends Item> c) {
        super(c);this.orderId = orderId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId (int orderId) {
        this. orderId = orderId;
    }
}



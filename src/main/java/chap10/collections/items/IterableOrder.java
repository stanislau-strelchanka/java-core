package chap10.collections.items;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Stas on 11/01/2015.
 */
public class IterableOrder implements Iterable<Item> {


    private int orderId;
    private List<Item> listItems;
    // private float amount; // не нужен, т.к. сумму можно вычислить
    public IterableOrder(int orderId, List<Item> listItems) {
        this.orderId = orderId;
        this.listItems = listItems;
    }
    public int getOrderId () {
        return orderId;
    }
    public List<Item> getListItems() {
        return Collections.unmodifiableList(listItems);
    }
    // некоторые делегированные методы интерфейсов List и Collection
    public boolean add(Item e) {
        return listItems.add(e);
    }
    public Item get(int index) {
        return listItems.get(index);
    }
    public Item remove(int index) {
        return listItems.remove(index);
    }
    // создание итератора
    @Override
    public Iterator<Item> iterator() {
        return listItems.iterator();
    }

}

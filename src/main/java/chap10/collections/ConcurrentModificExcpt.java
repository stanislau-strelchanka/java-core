package chap10.collections;

import chap10.collections.items.Order;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by Stas on 11/01/2015.
 */
public class ConcurrentModificExcpt {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<Order>();
        Iterator<Order> iterator = orders.iterator();
        orders.add(new Order(2,2f));
        try {
            while (iterator.hasNext()) {
                Order next = iterator.next();
                System.out.println(next);
            }
        }catch (ConcurrentModificationException e){
            System.out.println("\nShould not modify collection after iterator extraction");
        }
    }
}

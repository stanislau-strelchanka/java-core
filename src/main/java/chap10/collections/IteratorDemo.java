package chap10.collections;

import chap10.collections.items.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Stas on 11/01/2015.
 */
public class IteratorDemo {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<Order>(){{
            add(new Order(231, 12f));
            add(new Order(389, 2.9f));
            add(new Order(217, 1.7f));
        }};
        System.out.println(findBiggerAmountOrder(10f,orders));
    }

    public static List<Order> findBiggerAmountOrder(float bigAmount, List<Order> orders){

        ArrayList<Order> bigPrices = new ArrayList<Order>();

        Iterator<Order> it = orders.iterator();
        while (it.hasNext()){
            Order next = it.next();
            if((next.getAmount()) >= bigAmount)
                bigPrices.add(next);
        }
        return bigPrices;
    }
}

package chap10.collections.lists;

import chap10.collections.items.Order;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Stas on 11/01/2015.
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Order> orders = new PriorityQueue<Order>();
        orders.add(new Order(2,2f));//ok

        new PriorityQueue<Order>(2, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return 0;
            }
        });

        //orders.add(new Order(2,2f));not ok,
        //as no comparable interface for
        //Order is provided

        PriorityQueue<String> strings = new PriorityQueue<String>();
        strings.add("cccc");
        strings.add("aaaa");
        strings.add("bbbb");

        System.out.println(strings);//wtf???
    }
}

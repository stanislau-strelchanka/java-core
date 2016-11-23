package chap10.collections.lists;

import chap10.collections.items.Order;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Stas on 11/01/2015.
 */
public class LinkedListDemo {

    public static void main(String[] args) {


        LinkedList<Order> orders = new LinkedList<Order>() {
            {
                add(new Order(231, 12.f));
                add(new Order(389, 2.9f));
                add(new Order(217, 1.7f));
            }
        };

        Queue<Order> queue = orders;
        boolean offer = orders.offer(new Order(2, 2f));
        System.out.println(offer);

        Deque<Order> deque = orders;
        Order last = orders.getLast();
        System.out.println(last);

        orderProcessing(orders);
        deleteAll(orders);
    }

    public static void orderProcessing(Queue<Order> orders){

        Order poll = null;
        while ((poll = orders.poll()) != null)
        {
            System.out.println(poll);
        }
    }

    public static void deleteAll(LinkedList<Order> orders){

        while(orders.remove() != null);
        orders.remove();

    }
}

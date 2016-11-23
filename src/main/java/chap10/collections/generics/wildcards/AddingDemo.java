package chap10.collections.generics.wildcards;

import chap10.collections.items.DiscountOrder;
import chap10.collections.items.Order;
import chap10.collections.items.SuperDiscountOrder;
import chap10.collections.items.SuperDuperDiscountOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 11/01/2015.
 */
public class AddingDemo {

    private static ArrayList<Order> orders;
    private static ArrayList<DiscountOrder> discountOrders;
    private static ArrayList<SuperDiscountOrder> superDiscountOrders;
    private static ArrayList<SuperDuperDiscountOrder> superDuperDiscountOrder;

    private static void initLists() {
        orders = new ArrayList<Order>(){{
            add(new Order(231, 12f));
            add(new Order(389, 2.9f));
            add(new Order(217, 1.7f));
        }};
        discountOrders = new ArrayList<DiscountOrder>(){{
            add(new DiscountOrder(231, 12f));
            add(new DiscountOrder(389, 2.9f));
            add(new DiscountOrder(217, 1.7f));
        }};
        superDiscountOrders = new ArrayList<SuperDiscountOrder>(){{
            add(new SuperDiscountOrder(231, 12f));
            add(new SuperDiscountOrder(389, 2.9f));
            add(new SuperDiscountOrder(217, 1.7f));
        }};
        superDuperDiscountOrder = new ArrayList<SuperDuperDiscountOrder>(){{
            add(new SuperDuperDiscountOrder(231, 12f));
            add(new SuperDuperDiscountOrder(389, 2.9f));
            add(new SuperDuperDiscountOrder(217, 1.7f));
        }};
    }


    public static void main(String[] args) {

        initLists();
        testExtends(orders);
        testExtends(discountOrders);
        testExtends(superDiscountOrders);
        testExtends(superDuperDiscountOrder);

        System.out.println();
        testSuper(orders);
        testSuper(discountOrders);
        testSuper(superDiscountOrders);
        //testSuper(superDuperDiscountOrder); not allowed
    }

    public static void testExtends(List<? extends Order> orders){

        System.out.println("Testing Extends....");
        System.out.println("Item is type of " + orders.get(0).getClass().getName());
        List<Order> o = new ArrayList<Order>(orders);
        // orders.add(new Order(3,24f)); not allowed
        for (Order order : o) {
            System.out.print(order);
        }
        System.out.println();
        o.remove(0);
        for (Order order : o) {
            System.out.print(order);
        }
        System.out.println();
    }

    public static void testSuper(List<? super SuperDiscountOrder> orders){

        System.out.println("Testing Super....");
        System.out.println("Item is type of " + orders.get(0).getClass().getName());
        List<Object> o = new ArrayList<Object>(orders);
        for (Object order : o) {
            System.out.print(order);
        }
        System.out.println();
        o.remove(0);
        for (Object order : o) {
            System.out.print(order);
        }

        try{

            SuperDiscountOrder superDiscountOrder = (SuperDiscountOrder) orders.get(0);
            System.out.println("\nCast successful");
        }catch (ClassCastException e){

            System.out.println("\nCannot cast " + orders.get(0).getClass().getSimpleName() + " to SuperDiscountOrder");
        }
        System.out.println();
    }
}

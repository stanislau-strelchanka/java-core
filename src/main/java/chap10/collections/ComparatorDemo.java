package chap10.collections;

import chap10.collections.items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Stas on 11/01/2015.
 */
public class ComparatorDemo {

    public static void main(String[] args) {

        ArrayList<Item> p = new ArrayList<Item>() {
            {
                add(new Item(52201, 9.75f, "T-Shirt"));
                add(new Item(52127, 13.99f, "Dress"));
                add(new Item(47063, 45.95f, "Jeans"));
                add(new Item(90428, 60.9f, "Gloves"));
                add(new Item(53295, 31f, "Shirt"));
                add(new Item(63220, 14.9f, "Tie"));
            }
        };

        Comparator<Item> comparator = new Comparator<Item>(){

            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };

        Collections.sort(p,comparator);
        System.out.println(p);

        Collections.sort(p, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });

        System.out.println(p);
    }
}

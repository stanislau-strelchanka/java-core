package chap10.collections.inheritedCollections;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Stas on 12/01/2015.
 */
public class HashTableDemo {
    public static void main(String[ ] args) {
        Hashtable<Integer, Double> ht = new Hashtable<Integer, Double>() {
            {
                for (int i = 0; i < 5; i++) {
                    this.put(i, Math .atan(i));
                }
            }
        };
        Enumeration<Integer> ek = ht.keys();
        int key;
        while (ek.hasMoreElements()) {
            key = ek.nextElement();
            System.out.printf("%4d  ", key);
        }
        System.out.println("");
        Enumeration<Double> ev = ht.elements();
        double value;
        while (ev.hasMoreElements()) {
            value = ev.nextElement();
            System.out.printf("%.2f  ", value);
        }
    }
}

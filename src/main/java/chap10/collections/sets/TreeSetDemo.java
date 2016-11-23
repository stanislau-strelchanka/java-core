package chap10.collections.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Stas on 12/01/2015.
 */
public class TreeSetDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        boolean b;
        for (int i = 0; i < 6; i++) {
            list.add((int) (Math.random() * 10) + "Y ");
        }
        System.out.println(list + "список");
        TreeSet<String> treeSet = new TreeSet<String>(list); //new TreeSet(Comparator)

        System.out.println(treeSet + "множество");
        System.out.println(treeSet.comparator()); // null – String реализует Comparable
        // извлечение наибольшего и наименьшего элементов
        System.out.println(treeSet.last() + " " + treeSet.first());
        HashSet<String> hSet = new HashSet<String>(treeSet);
        for (String str : hSet) {
            System.out.println(str + "    " + str.hashCode());
        }
    }
}

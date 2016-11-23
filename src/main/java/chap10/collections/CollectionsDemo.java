package chap10.collections;

import java.util.*;

/**
 * Created by Stas on 12/01/2015.
 */
public class CollectionsDemo {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer n, Integer m) {

                return m.intValue() - n.intValue();
            }
        };

        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,2,3,4,5);
        Collections.shuffle(list);
        print(list);

        Collections.reverse(list);
        print(list);
        Collections.rotate(list,3);
        print(list);

        System.out.println("min: " + Collections.min(list,comparator));
        System.out.println("max: " + Collections.max(list,comparator));

        List<Integer> singl = Collections.singletonList(71);
        print(singl);

        // singl.add(21); error
    }

    private static void print(List<Integer> list) {

        for (Integer integer : list) {

            System.out.print(integer + " ");
        }
        System.out.println();
    }
}

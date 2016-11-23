package chap10.collections;

import java.util.*;

/**
 * Created by Stas on 28/01/2015.
 */
public class SortingDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String,Integer>();

        map.put("Java",22);
        map.put("C#",3);
        map.put("A#",3);
        map.put("www",1);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> array = new ArrayList<Map.Entry<String, Integer>>(entries);
        System.out.println(array);
        Collections.sort(array, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() > o2.getValue())
                    return 1;
                else if(o1.getValue() < o2.getValue())
                    return -1;
                else
                {
                    if(o1.getKey().compareTo(o2.getKey()) > 0)
                        return 1;
                    return -1;
                }
            }
        });

        map = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> elem : array) {

            map.put(elem.getKey(),elem.getValue());
        }

        System.out.println(map);

    }
}

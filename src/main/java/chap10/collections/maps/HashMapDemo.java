package chap10.collections.maps;

import java.util.*;

/**
 * Created by Stas on 12/01/2015.
 */
public class HashMapDemo {

    public static void main(String[] args) {


        HashMap<String, Integer> hm = new HashMap<String, Integer>(){
            {
                this.put("Сырок",3);
                this.put("Пряник",5);
                this.put("Молоко",1);
                this.put("Хлеб",1);
            }
        };

        hm.put("Пряник", 4); // замена или добавление при отсутствии ключа
        System.out.println(hm + "после замены элемента");
        Integer a = hm.get("Хлеб");
        System.out.println(a + " - найден по ключу 'Хлеб'");
        // вывод хэш-таблицы с помощью методов интерфейса Map.Entry<K,V>
        Set<Map.Entry<String, Integer>> setv = hm.entrySet();
        System.out.println(setv);
        Iterator<Map.Entry<String, Integer>> i = setv.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Integer> me = i.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        Set<Integer> val = new HashSet<Integer>(hm.values());
        System.out.println(val);

    }
}

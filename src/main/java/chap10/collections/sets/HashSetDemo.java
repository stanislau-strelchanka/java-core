package chap10.collections.sets;


import helpers.Helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Stas on 11/01/2015.
 */
public class HashSetDemo {

    public static void main(String[] args) {

        HashSet<String> words = new HashSet<String>(100);
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(Helper.PATH10 + "nabokov.txt"));
            scanner.useDelimiter("[^A-z]+");
            while (scanner.hasNext()){
                words.add(scanner.next().toLowerCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(words);

    }
}

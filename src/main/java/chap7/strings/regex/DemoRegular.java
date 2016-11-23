package chap7.strings.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Stas on 10/01/2015.
 */
public class DemoRegular {

    public static void main(String[] args) {

        String text = "This is the text to be searhed for occurences of the http:// pattern.";
        boolean matches = Pattern.matches(".*http://.*", text);
        System.out.println(matches);
        Pattern p1 = Pattern.compile("a+y");
        Matcher m1 = p1.matcher("aaay");
        System.out.println(m1.matches());

        String regex = "(\\w{6,})@(\\w+\\.)([a-z]{2,4})";
        String s = "адреса эл.почты:blinov@gmail.com, romanchik@bsu.by!";
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s);
        System.out.println(m2.matches());//wtf???
        while(m2.find()){

            System.out.println("e-mail: " + m2.group());
        }

        Pattern p3 = Pattern.compile("\\d+\\s?");
        String[ ] words = p3.split("java5tiger 77 java6mustang");
        System.out.print(Arrays.toString(words));

        Pattern pattern = Pattern.compile("(1*)0");
        Matcher matcher = pattern.matcher("111110");
        matcher.find();
        System.out.println(matcher.group());
    }
}

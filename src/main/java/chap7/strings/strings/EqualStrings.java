package chap7.strings.strings;

/**
 * Created by Stas on 09/01/2015.
 */
public class EqualStrings {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String(s1);

        System.out.println(s1 + " == " + s2 + " : " + (s1 == s2));
        System.out.println(s3 + " == " + s4 + " : " + (s3 == s4));
        System.out.println(s1 + " == " + s3 + " : " + (s1 == s3));
        System.out.println(s1 + " equals " + s2 + " : " + (s1.equals(s2)));
        System.out.println(s1 + " equals " + s3 + " : " + (s1.equals(s3)));

        s3 = s3.intern();
        System.out.println("After intern s3");
        System.out.println(s3 + " == " + s4 + " : " + (s3 == s4));
        System.out.println(s1 + " == " + s3 + " : " + (s1 == s3));

    }
}

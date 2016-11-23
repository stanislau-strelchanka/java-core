package chap7.strings.strings;

/**
 * Created by Stas on 09/01/2015.
 */
public class EqualsStringBuffer {

    public static void main(String[] args) {

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(48);
        StringBuffer sb3 = new StringBuffer();
        sb1.append("Java");
        sb2.append("Java");
        sb3.append("Java");
        System.out.println(sb1.equals(sb2));//false
        System.out.println(sb1.hashCode() == sb2.hashCode());//false
        System.out.println(sb1.hashCode() == sb3.hashCode());//false
        System.out.println(sb1.toString().contentEquals(sb2));//true

    }
}

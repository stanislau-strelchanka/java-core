package chap7.strings.strings;

/**
 * Created by Stas on 09/01/2015.
 */
public class RefStringBuilder {

    public static void changeStr(StringBuilder str){
        str.append(" Certified");
    }

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("Oracle");

        changeStr(str);
        System.out.println(str);

        String str2 = "Oracle";
        str2.concat(" Certified");
        System.out.println(str2);
    }
}



package chap7.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Stas on 10/01/2015.
 */
public class Groups {

    public static void main(String[] args) {


        String input = "abdcxyz";
        simpleMatches ("([ a-z]*)([a-z]+)", input);
        simpleMatches ("([ a-z]?)([a-z]+)", input);
        simpleMatches ("([ a-z]+)([a-z]*)", input);
        simpleMatches ("([ a-z]?)([a-z]?)", input);
    }

    public static  void simpleMatches(String regex, String input){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){

            System.out.println("First Group: " + matcher.group(1));
            System.out.println("Second Group: " + matcher.group(2) + "\n");
        }
        else {
            System.out.println("nothing\n");
        }
    }
}

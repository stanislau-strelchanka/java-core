package chap7.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Stas on 10/01/2015.
 */
public class DemoMatcherAdvanced {

    static String text = "This is the text to be searched for occurrences of the http:// pattern.";
    static String text2 = "This is the text which is to be searched for occurrences of the word 'is'.";
    static String text3 = "John wirtes about this, and John writes about that, and John writes about everything.";
    static String text4 = "John wirtes about this, and John Doe writes about that, and John Wayne writes about everything.";


    private static String patternString;

    public static void main(String[] args) {

        testMatches();
        testLookingAt();
        testFindStartEndExample();
        testGroup();
        testMultipleGroups();
        testGroupInsideGroup();
        testReplace();
        testAppendReplace();
    }



    public static void testMatches(){

        System.out.println("TestMatches");
        patternString = ".*http://.*";
        System.out.println("testMatches, pattern " + patternString);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);//creating mather through pattern
        System.out.println(matcher.matches());
    }

    public static void testLookingAt(){

        System.out.println("testLookingAt");
        patternString = "This is the";
        System.out.println("testLookingAt, pattern " + patternString);
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("mathes = " + matcher.matches());
    }

    public static void testFindStartEndExample(){

        System.out.println("testFindStart");
        patternString = "is";
        Pattern compile = Pattern.compile(patternString);
        Matcher matcher = compile.matcher(text2);

        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
            //can use substring to get this string
            //reset - resets start(), end()
        }
    }

    public static void testGroup(){

        System.out.println("testGroup");
        patternString = "(John)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text3);

        while (matcher.find()){
            System.out.println("found: " + matcher.group(1));
        }
    }

    public static void testMultipleGroups(){

        System.out.println("testMultipleGroups");
        patternString = "(John) (.+?) ";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text4);
        while (matcher.find()){
            System.out.println("found: " + matcher.group(1) + " " + matcher.group(2));
        }
    }

    public static void testGroupInsideGroup() {

        System.out.println("testGroupInsideGroup");
        patternString = "((John) (.+?) )";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text4);

        while (matcher.find()){
            System.out.println("found: <" + matcher.group(1) +
                                "> <" + matcher.group(2) + "> " +
                                "> <" + matcher.group(3) + "> ");
        }
    }

    public static void testReplace(){

        System.out.println("testReplace");
        patternString = "((John) (.+?) )";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text4);
        System.out.println(matcher.replaceAll("Joe Blocks "));
        System.out.println(matcher.replaceFirst("Joe Blocks "));
    }

    public static void testAppendReplace(){

        System.out.println("testAppendReplace");
        patternString = "((John) (.+?) )";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text4);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()){
            matcher.appendReplacement(sb, "Joe Blocks ");
            System.out.println(sb.toString());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}

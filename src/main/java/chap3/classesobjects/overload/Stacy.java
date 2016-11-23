package chap3.classesobjects.overload;

/**
 * Created by Stas on 10/01/2015.
 */
public class Stacy {

    public Integer getAge(String str){

        System.out.println("getAge String str");
        return 23;
    };
    //public String getAge(String str){return "23";}; not allowed
    public Integer getAge(Object str) {

        System.out.println("getAge Object str");
        return 23;};

    public Integer getAge(Integer str){

        System.out.println("getAge Integer str");
        return 23;
    }

    public Integer getAge(int str){
        System.out.println("getAge int str");
        return 23;
    }

    //try to comment this
    public Integer getAge(Number str){
        System.out.println("getAge Number str");
        return 23;
    }

    public Integer getAge(double str){

        System.out.println("getAge double str");
        return 23;
    }

    public Integer getAge(int a, long b){
        return 23;
    }

    public Integer getAge(long a, int b){
        return 23;
    }

    public void testCovariance(Object o){};

    public static void main(String[] args) {

        Stacy stacy = new Stacy();
        stacy.getAge(new Object());
        stacy.getAge(new Integer(23));
        stacy.getAge(23);

        //choice of overloaded method occures at the compile time:
        Number[] num = {3.1d,5,5.28f,new Integer(55)};
        for (Number number : num) {
            stacy.getAge(number);
        }

        main();
        //getAge(2,2); ambiguous method call
        int i = 5;
        stacy.testCovariance(i);
    }

    public static void main(){

        System.out.println("overriden main");
    }


}

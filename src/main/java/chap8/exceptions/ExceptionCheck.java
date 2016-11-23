package chap8.exceptions;

/**
 * Created by Stas on 14/01/2015.
 */
public class ExceptionCheck {

    public static void main(String[] args) {

        try{

        try{

            throw new Exception();
        }catch (NullPointerException e){

            System.out.println("nullpointexception");
        }
        catch (Exception e){

            System.out.println("exception");
            throw new NullPointerException();
        }
        catch (Throwable e){

            System.out.println("throwable");
        }
        }catch (NullPointerException e){
            System.out.println("nullpointerexception");
        }
    }
}

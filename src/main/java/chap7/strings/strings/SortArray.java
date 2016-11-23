package chap7.strings.strings;

/**
 * Created by Stas on 09/01/2015.
 */
public class SortArray {

    public static void main(String[] args) {

        String names = "   Alena   Alice     alina albina     Anastasya   ALLA ArinA     ";
        names = names.trim();
        String[] a = names.split(" ");
        for (int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i].compareToIgnoreCase(a[j]) < 0){
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (String s : a) {
            if(!s.isEmpty()){
                System.out.print(s);
            }
        }
    }
}

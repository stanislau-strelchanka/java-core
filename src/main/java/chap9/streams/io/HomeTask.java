package chap9.streams.io;

import java.io.*;

public class HomeTask {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("with_letters.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true));
        try {
            String s = br.readLine();
            while (s != null) {
                s = s.replace('I', '1');
                s = s.replace('E', '3');
                s = s.replace('T', '7');
                bw.write(s);
                bw.newLine();
                s = br.readLine();
            }
        } finally {
            br.close();
            bw.close();
        }
    }
}

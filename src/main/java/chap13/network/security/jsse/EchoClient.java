package chap13.network.security.jsse;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;

/**
 * Created by Stas on 04/03/2015.
 */
public class EchoClient {

    public static void main(String[] args) throws IOException{

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(InetAddress.getLocalHost().getHostAddress(), 9999);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = null;
        while (( s = bufferedReader.readLine()) != null){

            bufferedWriter.write(s);
            bufferedWriter.flush();
        }

    }
}

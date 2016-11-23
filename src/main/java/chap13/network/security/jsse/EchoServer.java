package chap13.network.security.jsse;

import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Stas on 04/03/2015.
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {

        SSLServerSocketFactory socketFactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        ServerSocket serverSocket = socketFactory.createServerSocket(9999);
        SSLSocket socket = (SSLSocket)serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = null;
        while((s = bufferedReader.readLine()) != null){
            System.out.println(s);
            System.out.flush();
        }
    }
}

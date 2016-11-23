package chap13.network.sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Stas on 23/02/2015.
 */
public class ThreadsSocketDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8071);
        System.out.println("Initialized");
        while(true){

            System.out.println("Waiting");
            Socket accept = serverSocket.accept();
            System.out.println("Connection accepted");
            new ServerThread(accept).start();
        }
    }
}

package chap13.network.sockets;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Stas on 23/02/2015.
 */
public class SimpleSocketDemo {

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run() {

                createServer();

            }
        }.start();
        Thread.sleep(1000);
        createClient();
    }

    public static void createServer(){

        try {
            ServerSocket serverSocket = new ServerSocket(10050);
            System.out.println("Waiting for acceptance");
            Socket accept = serverSocket.accept();
            System.out.println(accept.getInetAddress().getAddress() + " accepted!");
            PrintStream ps = new PrintStream(accept.getOutputStream());
            ps.println("yo!");
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createClient(){

        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            Socket socket = new Socket(host,10050);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Reading from server");
            System.out.println(reader.readLine());
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

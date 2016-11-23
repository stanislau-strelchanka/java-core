package chap13.network.udp;

import helpers.Helper;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Created by Stas on 27/02/2015.
 */
public class UDPRecipient {

    public static void main(String[] args) throws IOException {
        File file = new File(Helper.PATH13 + "reciever\\recieved_image.jpg");
        System.out.println("Прием данных...");

        acceptFile(file, 8033, 1024);
    }

    private static void acceptFile(File file, int port, int pacSize)
            throws IOException {



        try {

            byte[] bytes = new byte[pacSize];
            OutputStream os = new FileOutputStream(file);
            DatagramPacket dp = new DatagramPacket(bytes, pacSize);
            DatagramSocket ds = new DatagramSocket(port);
            ds.setSoTimeout(60000);

            while (true) {
                ds.receive(dp);
                System.out.println("Recieved " + bytes);
                os.write(bytes);
                os.flush();
            }

        } catch (SocketTimeoutException e) {
            // если время ожидания вышло
            System.err.println("Истекло время ожидания, прием данных закончен");

        }
    }
}

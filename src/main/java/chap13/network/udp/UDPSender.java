package chap13.network.udp;

import helpers.Helper;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Stas on 27/02/2015.
 */
public class UDPSender {

    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(Helper.PATH13 + "sender\\image.jpg");
        byte[] bytes = new byte[1024];
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramSocket ds = new DatagramSocket();
        while (is.read(bytes) != -1){
            StringBuffer message = new StringBuffer();
            for (byte aByte : bytes) {
                message.append(aByte);
            }
            System.out.println("Sending " + message);
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,localHost,8033);
            ds.send(dp);
        }
    }
}

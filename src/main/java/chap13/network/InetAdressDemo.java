package chap13.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Stas on 23/02/2015.
 */
public class InetAdressDemo {

    public static void main(String[] args) throws IOException {

        InetAddress currentIp = InetAddress.getLocalHost();
        InetAddress bsuIp = InetAddress.getByName("bsu.by");
        System.out.println(bsuIp.getHostAddress()+ " " + bsuIp.getHostName());
        System.out.println(bsuIp.getAddress());
        System.out.println(currentIp.getHostAddress() + " " + currentIp.getHostName() );
        System.out.println(currentIp.getAddress());

        byte ip[] ={(byte)217, (byte)21, (byte)43, (byte)3};
        InetAddress university = InetAddress.getByAddress("University", ip);
        System.out.println(university.getHostAddress() + " " + university.getHostName() + " :" + university.isReachable(1000));
    }
}

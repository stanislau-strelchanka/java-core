package chap13.network.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Stas on 23/02/2015.
 */
public class ServerThread extends Thread {

    private PrintStream os; // передача
    private BufferedReader is; // прием
    private InetAddress addr; // адрес клиента
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }


    @Override
    public void run() {

        String str = "";
        int i = 0;
        try {
            while((str = is.readLine()) == "PING"){
                os.println("PONG " + ++i);
            }
            System.out.println("PING-PONG " + i + " with "
                    +addr .getHostName());
        } catch (IOException e) {
            // если клиент не отвечает, соединение с ним разрывается
            System.err.println("Disconnect");
        }
        finally {
            disconnect();
        }
    }

    public void disconnect(){

        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}

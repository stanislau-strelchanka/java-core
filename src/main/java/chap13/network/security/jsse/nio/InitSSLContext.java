package chap13.network.security.jsse.nio;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Created by Stas on 02/03/2015.
 */
public class InitSSLContext {

    public static void main(String[] args) throws UnknownHostException {

        go(InetAddress.getLocalHost().getHostAddress(),0);
    }

    // Create/initialize the SSLContext with key material
    public static SSLEngine go(String hostname,int port){

        char[] passphrase = "pathstore".toCharArray();
        SSLEngine engine = null;

        try {

            // First initialize the key and trust material.
            KeyStore ksKeys = KeyStore.getInstance("JKS");
            ksKeys.load(new FileInputStream("testKeys"),passphrase);
            KeyStore ksTrust = KeyStore.getInstance("JKS");
            ksTrust.load(new FileInputStream("testTrust"), passphrase);

            // KeyManager's decide which key material to use.
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ksKeys,passphrase);

            // TrustManager's decide whether to allow connections.
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ksTrust);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            // We're ready for the engine.
            engine = sslContext.createSSLEngine(hostname, port);

            // Use as client
            engine.setUseClientMode(true);
            return engine;

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return engine;
    }
}

package com.example.seraphzxz.androidsocket.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by seraphzxz on 18-4-18.
 */
public class SocketClient {

    static {
        System.loadLibrary("native-lib");
    }

    static public void connect(final String host, final int port, final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintWriter printWriter;
                    BufferedReader in;
                    Socket socket = new Socket(host, port);
                    socket.setSoTimeout(60000);

                    printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(

                            socket.getOutputStream(),"UTF-8")),true);

                    printWriter.println(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    static public void jniConnect(final String host, final int port){
        new Thread(new Runnable() {
            @Override
            public void run() {
                connectByJni(host,port);
            }
        }).start();
    }

    public static native void connectByJni(String host, int port);
}

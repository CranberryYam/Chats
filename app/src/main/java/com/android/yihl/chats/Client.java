package com.android.yihl.chats;


import android.os.NetworkOnMainThreadException;
import android.util.Log;

import java.io.*;
import java.net.*;


public class Client {
    private static final String host = "localhost";
    private static final int portNumber = 16790;

    private String userName;
    private String serverHost;
    private int serverPort;


    public Client(String userName, String serverHost, int serverPort) {
        this.userName = userName;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }
    public void begin() {
        try {
            Log.v("henry","go into begin()");
            Socket clientSocket = new Socket(serverHost, serverPort);
            Thread gThread = new Thread(new GetMsgThread(clientSocket));
            gThread.start();
            Thread sThread = new Thread(new SendMsgThread(clientSocket, userName));
            sThread.start();
        } catch (IOException e) {
            //System.out.println("clientSocket begin failed because " + e.getMessage());
            Log.v("henry","clientSocket begin failed because " + e.getMessage());
        } catch (NetworkOnMainThreadException e){
            Log.v("henry","clientSocket begin failed because " + e.getMessage());
        }
    }



}

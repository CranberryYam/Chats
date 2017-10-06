package com.android.yihl.chats;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;

import java.net.Socket;
import java.util.Scanner;

public class GetMsgThread implements Runnable{

    private Socket socket;
    private Scanner in;

    public GetMsgThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            in = new Scanner(socket.getInputStream());
            while (!socket.isClosed()) {
                Log.v("henry","start geting message");
                if(in.hasNextLine()) {
                    String newMessage = in.nextLine();
                    System.out.println("C: " + newMessage);

                }
            }
        } catch (Exception e) {
            System.out.println("get_message thread failed because " + e.getMessage());
        }
    }


}


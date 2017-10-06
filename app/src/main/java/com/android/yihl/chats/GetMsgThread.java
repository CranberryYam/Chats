package com.android.yihl.chats;

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


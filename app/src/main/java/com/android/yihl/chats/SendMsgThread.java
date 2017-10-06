package com.android.yihl.chats;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMsgThread implements Runnable{
    private Socket socket;
    private String userName;
    private PrintWriter out;
    private Scanner in;

    public SendMsgThread(Socket socket,String userName) {
        this.socket = socket;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(System.in);
            System.out.println("C: Please send messages");
            while (!socket.isClosed()) {
                if(in.hasNextLine()) {
                    String newMessage = in.nextLine();
                    newMessage = userName + ":" + newMessage;
                    out.println(newMessage);
                    System.out.println("C: Please send messages");
                }
            }

        } catch (IOException e) {
            System.out.println("send_message thread failed because " + e.getMessage());
        }

    }

}


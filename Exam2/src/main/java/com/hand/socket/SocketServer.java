package com.hand.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread{

    @Override
    public void run() {
        super.run();

        try {
            ServerSocket server=new ServerSocket(12345);

            while(true){
                Socket socket=server.accept();
                System.out.println("server is started!");
                HandlerSocket hs = new HandlerSocket(socket);
                hs.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

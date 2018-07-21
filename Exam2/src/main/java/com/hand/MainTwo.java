package com.hand;


import com.hand.socket.ClientSocket;
import com.hand.socket.SocketServer;

public class MainTwo {
    public static void main(String[] args) {
        SocketServer server=new SocketServer();
        server.start();
        ClientSocket c1=new ClientSocket("localhost",12345);
        c1.start();
    }
}

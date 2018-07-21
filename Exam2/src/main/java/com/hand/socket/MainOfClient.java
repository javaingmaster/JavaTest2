package com.hand.socket;

public class MainOfClient {
    public static void main(String[] args) {
        ClientSocket c1=new ClientSocket("localhost",12345);
        c1.start();
    }
}

package com.hand.socket;

import java.io.*;
import java.net.Socket;

public class HandlerSocket extends Thread{

    private Socket s;
    public InputStream input;
    public OutputStream output;
    public InputStreamReader in;

    public HandlerSocket(Socket s){
        try {
            this.s=s;
            input=s.getInputStream();
            output=s.getOutputStream();
            in=new InputStreamReader(input,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            //发送pdf
            File f=new File("D:\\JavaTest2\\JavaTest2\\Exam1\\tmp\\SampleChapter1.pdf");
            FileInputStream inputStream=new FileInputStream(f);
            byte[] buffer=new byte[1024];
            while(inputStream.read(buffer)!=-1){
                output.write(buffer);
            }
            output.flush();
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

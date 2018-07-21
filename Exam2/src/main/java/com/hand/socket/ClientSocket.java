package com.hand.socket;
import java.io.*;
import java.net.Socket;

public class ClientSocket extends Thread{
    private Socket client;
    private String host;
    private int port;
    public OutputStream output;
    public InputStream in;
    public InputStreamReader input;

    public ClientSocket(String host,int port){
        try {
            this.host=host;
            this.port=port;
            client=new Socket(host,port);
            output=client.getOutputStream();
            in=client.getInputStream();
            input=new InputStreamReader(in,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接受信息
     */

    public void receive(InputStreamReader input) {
        File f=new File("Exam1\\tmp\\SampleChapter1.pdf");
        File local=new File("Exam2\\tmp\\SampleChapter1.pdf");
        if (!local.exists()){
            try {
                local.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(local);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean isdone=false;
        while (!isdone) {
            try {

                byte[] buffer=new byte[1024];
                while (in.read(buffer)!=-1){
                    fileOutputStream.write(buffer);
               }
                fileOutputStream.flush();
                fileOutputStream.close();
                isdone=true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        super.run();

        receive(input);
    }
}

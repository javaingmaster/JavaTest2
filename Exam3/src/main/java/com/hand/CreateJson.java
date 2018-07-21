package com.hand;

import com.google.gson.JsonObject;

import java.io.*;

public class CreateJson extends Thread {
    private  String text;
    public  CreateJson(String text){
        this.text=text;
    }

    @Override
    public void run() {
        super.run();

        String step1=text.substring(text.indexOf("=")+2,text.indexOf(";")-1);
        String[] values=step1.split(",");

        JsonObject jo=new JsonObject();
        jo.addProperty("name",values[0]);
        jo.addProperty("open",values[1]);
        jo.addProperty("close",values[2]);
        jo.addProperty("current",values[3]);
        jo.addProperty("high",values[4]);
        jo.addProperty("low",values[5]);

        try {
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("Exam3\\tmp\\股票编码.json"),"UTF-8");
            BufferedWriter out=new BufferedWriter(outputStreamWriter);

            char[] buff=jo.toString().toCharArray();
            out.write(buff);
            out.flush();
            out.close();
            System.out.println("解析json成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

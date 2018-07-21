package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class DownLoad {
    public void download(){

        HttpClient client=HttpClients.createDefault();
        HttpGet get=new HttpGet("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");

        try {
            HttpResponse response =client.execute(get);
            HttpEntity entity=response.getEntity();

            byte[] buffer=EntityUtils.toByteArray(entity);

            File f=new File("D:\\JavaTest2\\JavaTest2\\Exam1\\tmp\\SampleChapter1.pdf");
            if(!f.exists()){
                f.createNewFile();
            }
            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(f));
            out.write(buffer);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

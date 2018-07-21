package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DataProcess {
    private String input;
    public DataProcess(String input){
        this.input=input;
    }

    public String getData(){
        try {
            System.out.println("开始获取数据");
            HttpClient client=HttpClients.createDefault();
            HttpGet get=new HttpGet("http://hq.sinajs.cn/list="+input);

            HttpResponse response = null;

            response = client.execute(get);
            HttpEntity entity=response.getEntity();
            String result=EntityUtils.toString(entity);

            if(result!=null)
                System.out.println("数据获取成功");

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

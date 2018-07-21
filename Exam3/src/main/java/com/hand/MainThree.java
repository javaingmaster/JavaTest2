package com.hand;

public class MainThree {
    public static void main(String[] args) {
        try {
            String input=args[0];
            DataProcess dataProcess=new DataProcess("sz300170");
            String result=dataProcess.getData();

            CreateXml cx=new CreateXml(result);
            cx.start();
            CreateJson cj=new CreateJson(result);
            cj.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

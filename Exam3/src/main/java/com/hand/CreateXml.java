package com.hand;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class CreateXml extends Thread {

    private  String text;
    public  CreateXml(String text){
        this.text=text;
    }

    @Override
    public void run() {
        super.run();

        String step1=text.substring(text.indexOf("=")+2,text.indexOf(";")-1);
        String[] values=step1.split(",");

        Document document=DocumentHelper.createDocument();
        document.addComment("xml数据：");
        Element stock=document.addElement("stock");

        Element name= stock.addElement("name");
        stock.addText(values[0]);
        Element open= stock.addElement("open");
        stock.addText(values[1]);
        Element close= stock.addElement("close");
        stock.addText(values[2]);
        Element current= stock.addElement("current");
        stock.addText(values[3]);
        Element high= stock.addElement("high");
        stock.addText(values[4]);
        Element low= stock.addElement("low");
        stock.addText(values[5]);

        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        Writer out;
        try {

            File file=new File("D:\\JavaTest2\\JavaTest2\\Exam3\\tmp\\股票编码.xml");
            if (!file.exists()){
                file.createNewFile();
            }
            out=new FileWriter(file);
            XMLWriter xmlWriter=new XMLWriter(out,format);
            xmlWriter.write(document);
            xmlWriter.close();
            System.out.println("解析xml成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

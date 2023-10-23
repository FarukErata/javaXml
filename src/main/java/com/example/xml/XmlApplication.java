package com.example.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


//@SpringBootApplication
public class XmlApplication {

    public static void main(String[] args) {
       //SpringApplication.run(XmlApplication.class, args);
        try{

            File file = new File("C:/Users/DELL/Desktop/productinfo/product1.xml");
            //File file2 = new File("C:/Users/DELL/Desktop/productinfo/product2.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc=db.parse(file);
            NodeList nodeList=doc.getElementsByTagName("test");
            for(int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                System.out.println("node name: "+node.getNodeName());

                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element tElement=(Element)node;
                    System.out.println("product name: "+ tElement.getElementsByTagName("ad").item(0).getTextContent());
                    System.out.println("product model: "+ tElement.getElementsByTagName("marka").item(0).getTextContent());
                    System.out.println("product type: "+ tElement.getElementsByTagName("tip").item(0).getTextContent());
                    System.out.println("product price: "+ tElement.getElementsByTagName("fiyat").item(0).getTextContent());
                    System.out.println("product date: "+ tElement.getElementsByTagName("tarih").item(0).getTextContent());
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }


}

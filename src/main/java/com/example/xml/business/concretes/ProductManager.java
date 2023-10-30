package com.example.xml.business.concretes;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.dataAccess.ProductDao;
import com.example.xml.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;


@Service
public class ProductManager implements IProduct {


    @Autowired
    private ProductDao productDao;

//public ProductManager(){
//
//}
//    @Autowired
//    public ProductManager(ProductDao productDao){
//        super();
//        this.productDao=productDao;
//    }

    public void Read(){
        try{
            ProductEntity entity=new ProductEntity();

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


                    entity.setName(tElement.getElementsByTagName("ad").item(0).getTextContent());
                    entity.setType(tElement.getElementsByTagName("tip").item(0).getTextContent());
                    entity.setModel(tElement.getElementsByTagName("marka").item(0).getTextContent());
                    entity.setPrice(tElement.getElementsByTagName("fiyat").item(0).getTextContent());
                    entity.setDate(tElement.getElementsByTagName("tarih").item(0).getTextContent());
                }
                 productDao.save(entity);
            }

        }catch(Exception e){
            System.out.println(e);
        }


    }


    @Override
    public void xmlSave() {
    }

    @Override
    public List<ProductEntity> findByName(String name){
        return productDao.findAll();
    }
    @Override
    public List<ProductEntity> find(String model){
        return productDao.findAll();
    }
}

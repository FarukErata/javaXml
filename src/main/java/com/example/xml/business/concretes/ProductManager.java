package com.example.xml.business.concretes;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.dataAccess.DatePriceDao;
import com.example.xml.dataAccess.ProductDao;
import com.example.xml.dataAccess.UnionDao;
import com.example.xml.model.DatePrice;
import com.example.xml.model.ProductDto;
import com.example.xml.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.persistence.TypedQuery;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.Statement;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductManager implements IProduct {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private DatePriceDao datePriceDao;
    private String pattern="dd-MM-yyyy";
    String dateInString=new SimpleDateFormat(pattern).format(new Date());

    @Autowired
    public ProductManager(ProductDao productDao, DatePriceDao datePriceDao){
        super();
        this.productDao= productDao;
        this.datePriceDao= datePriceDao;

    }

    @Override
    public void read(){
        try{


            File directoryPath=new File("C:/Users/DELL/Desktop/productinfo/");
            String contents[]=directoryPath.list();
            for (String content : contents) {
                ProductEntity entity=new ProductEntity();
                DatePrice dp= new DatePrice();
                Date d= new Date();


                File file = new File("C:/Users/DELL/Desktop/productinfo/" + content);


                //File file = new File("C:/Users/DELL/Desktop/productinfo/");
                //File file2 = new File("C:/Users/DELL/Desktop/productinfo/product2.xml");

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                NodeList nodeList = doc.getElementsByTagName("test");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);


                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element tElement = (Element) node;

                        entity.setId(Integer.parseInt(tElement.getElementsByTagName("id").item(0).getTextContent()));
                        entity.setName(tElement.getElementsByTagName("ad").item(0).getTextContent());
                        entity.setType(tElement.getElementsByTagName("tip").item(0).getTextContent());
                        entity.setModel(tElement.getElementsByTagName("marka").item(0).getTextContent());
                        dp.setPrice(tElement.getElementsByTagName("fiyat").item(0).getTextContent());
                        //date-->getdate
                    }

                }

               dp.setDate(dateInString);

                productDao.save(entity);
                dp.setProduct(entity);
                datePriceDao.save(dp);

            }
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public List<ProductEntity> findByName(String name){
        return productDao.findByName(name);
    }
    @Override
    public List<ProductEntity> findByModel(String model){
        return productDao.findByModel(model);
    }

    @Override
    public List<DatePrice> orderByPrice(String date){
        return datePriceDao.findByDate(date);
    }


}

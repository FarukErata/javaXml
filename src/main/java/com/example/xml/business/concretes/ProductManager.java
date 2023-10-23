package com.example.xml.business.concretes;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.dataAccess.ProductDao;
import com.example.xml.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductManager implements IProduct {


    @Autowired
    private ProductDao productDao;

    @Override
    public void xmlSave(ProductEntity entity) {

    }
}

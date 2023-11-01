package com.example.xml.business.abstracts;

import com.example.xml.model.ProductEntity;

import java.util.List;

public interface IProduct {
    void read();
    void xmlSave();
    List<ProductEntity> findByName(String name);
    List<ProductEntity> find(String model);
}

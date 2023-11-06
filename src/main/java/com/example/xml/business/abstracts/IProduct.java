package com.example.xml.business.abstracts;

import com.example.xml.model.ProductEntity;

import java.util.List;

public interface IProduct {
    void read();
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByModel(String model);
}

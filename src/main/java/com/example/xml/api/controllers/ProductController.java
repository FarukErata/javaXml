package com.example.xml.api.controllers;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.business.concretes.ProductManager;
import com.example.xml.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xml")
public class ProductController {

    @Autowired
    private IProduct iProduct;

    @Autowired
    private ProductManager productManager;

    public void xml(){
        productManager.Read();
    }

    @Autowired
    public ProductController(IProduct iProduct){
        this.iProduct=iProduct;
    }

    @GetMapping("/getByName")
    private List<ProductEntity> getProduct(@RequestParam String name){
       return this.iProduct.findByName(name);
    }

    @GetMapping("/getByModel")
    private List<ProductEntity> getByModel(@RequestParam String model){
        return this.iProduct.find(model);
    }



}

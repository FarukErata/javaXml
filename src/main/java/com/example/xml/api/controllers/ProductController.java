package com.example.xml.api.controllers;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.business.concretes.ProductManager;
import com.example.xml.model.DatePrice;
import com.example.xml.model.ProductDto;
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


    @Autowired
    public ProductController(IProduct iProduct){
        this.iProduct=iProduct;
    }

    @GetMapping("/save")
    private void save(){
        this.iProduct.read();
    }

    @GetMapping("/getByName")
    private List<ProductEntity> getProduct(@RequestParam String name){
       return this.iProduct.findByName(name);
    }

    @GetMapping("/getByModel")
    private List<ProductEntity> getByModel(@RequestParam String model){
        return this.iProduct.findByModel(model);
    }

    @GetMapping("/orderByDate")
    private List<DatePrice> orderByDate(@RequestParam String date){
        return this.iProduct.orderByPrice(date);
    }





}

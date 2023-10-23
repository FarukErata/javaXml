package com.example.xml.api.controllers;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("/xml")
public class ProductController {

    @Autowired
    private IProduct iProduct;

    @Autowired
    public ProductController(IProduct iProduct){
        this.iProduct=iProduct;
    }

    @GetMapping("/getproduct")
    private List<ProductEntity> getProduct(){
        return null;//this.iproduct.getproducts();
    }
}

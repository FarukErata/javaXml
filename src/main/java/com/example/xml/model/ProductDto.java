package com.example.xml.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProductDto {
    @Id
    private int id;
    private String name;
    private String model;
    private String type;
    private String price;
    private String date;

    public ProductDto(String name, String model, String type, String price, String date) {
        this.name = name;
        this.model = model;
        this.type = type;
        this.price = price;
        this.date = date;
    }

    public ProductDto() {

    }
}

package com.example.xml.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Xml")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ad")
    private String name;
    @Column(name="marka")
    private String model;
    @Column(name="type")
    private String type;
    @Column(name="fiyat")
    private String price;
    @Column(name="tarih")
    private String date;

    public ProductEntity() {

    }


    public ProductEntity(String name, String model, String type, String price, String date) {
        this.name = name;
        this.model = model;
        this.type = type;
        this.price = price;
        this.date = date;
    }



    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

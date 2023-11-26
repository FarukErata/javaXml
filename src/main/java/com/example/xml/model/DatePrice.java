package com.example.xml.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Date")
public class DatePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="price_id")
    private int priceId;
    @Column(name = "tarih")
    private String date;
    @Column(name = "fiyat")
    private String price;



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="product_id",nullable = false)
    private ProductEntity product;

    public DatePrice() {

    }

    public DatePrice(int priceId, String date, String price,ProductEntity product) {
        this.priceId = priceId;
        this.date = date;
        this.price = price;
        this.product=product;
    }

    @Override
    public String toString() {
        return "DatePrice{" +
                "priceId=" + priceId +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

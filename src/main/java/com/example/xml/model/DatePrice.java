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
    @Column(name="xmlid")
    private int xmlid;


//    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
//    @JoinColumn(name="foreignid",referencedColumnName = "id")//foreignid,id
//    private ProductEntity product;

    public DatePrice() {

    }

    public DatePrice(int priceId, String date, String price) {
        this.priceId = priceId;
        this.date = date;
        this.price = price;
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

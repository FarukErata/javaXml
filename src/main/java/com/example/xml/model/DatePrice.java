package com.example.xml.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Date")
public class DatePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int priceId;
    @Column(name = "tarih")
    private String date;
    @Column(name = "fiyat")
    private String price;

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

package com.example.xml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
//@DynamicUpdate//Saves only the changed fields(update)
@Table(name="Xml")
public class ProductEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//id will come from xml files
    @Id
    @Column(name="id")
    private int id;
    @Column(name="ad")
    private String name;
    @Column(name="marka")
    private String model;
    @Column(name="type")
    private String type;



    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<DatePrice> datePriceSet;


    public ProductEntity() {

    }


    public ProductEntity(int id,String name, String model, String type) {
        this.id=id;
        this.name = name;
        this.model = model;
        this.type = type;
//        this.price = price;
//        this.date = date;
    }



    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

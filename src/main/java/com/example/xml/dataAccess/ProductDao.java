package com.example.xml.dataAccess;

import com.example.xml.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByModel(String model);

//    @Query(
//            nativeQuery = true,
//            value
//                    ="select [ad]\n" +
//                    "      ,[marka]\n" +
//                    "      ,[type]\n" +
//                    "\t  ,[fiyat],\n" +
//                    "\t  [tarih]from Xml\n" +
//                    "\t  INNER JOIN Date ON\n" +
//                    "\t  Xml.id=Date.xmlid\n" +
//                    "\t  WHERE tarih= ?1 \n" +
//                    "\t  ORDER BY fiyat"
//    )
//    List<ProductEntity> findByDate(String date);
}

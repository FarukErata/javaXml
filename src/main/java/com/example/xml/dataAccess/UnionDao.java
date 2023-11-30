package com.example.xml.dataAccess;

import com.example.xml.model.ProductDto;
import com.example.xml.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnionDao extends JpaRepository<ProductDto,Integer> {

    @Query(
            nativeQuery = true,
            value
                    ="select p.ad,p.marka,p.type,dp.fiyat,dp.tarih from Xml p INNER JOIN Date dp ON p.id=dp.product_id \n" +
                    " WHERE dp.tarih= :date ORDER BY fiyat "

    )
    List<ProductDto> findByDate(@Param("date") String date);


}

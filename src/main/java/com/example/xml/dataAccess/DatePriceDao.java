package com.example.xml.dataAccess;

import com.example.xml.model.DatePrice;
import com.example.xml.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatePriceDao extends JpaRepository<DatePrice,Integer> {
//    @Query(
//            nativeQuery = true,
//            value
//                        ="select p.ad,p.marka,p.type,dp.fiyat,dp.tarih from ProductEntity p INNER JOIN p.datePrice dp ON p.id=dp.product_id\n" +
//                    " WHERE dp.tarih= :date ORDER BY fiyat "
//    )
//    List<DatePrice> findByDate(@Param("date") String date);//or @Param("date") & tarih= :date
}

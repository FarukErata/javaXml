package com.example.xml.dataAccess;

import com.example.xml.model.DatePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatePriceDao extends JpaRepository<DatePrice,Integer> {
    @Query(
            nativeQuery = true,
            value
                    ="select * from Date Where tarih= ?1 ORDER BY fiyat"

    )
    List<DatePrice> findByDate(String date);//or @Param("date") & tarih= :date
}

package com.example.xml.dataAccess;

import com.example.xml.model.DatePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatePriceDao extends JpaRepository<DatePrice,Integer> {
}

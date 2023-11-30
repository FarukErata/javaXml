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
}

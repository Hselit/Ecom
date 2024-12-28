package com.java.learing.springboot.ECommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.learing.springboot.ECommerce.model.Product;
import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
    
    @Query("select p from Product p where "+"Lower(p.name) like lower(concat('%',:keyword,'%'))")
    List<Product> searchProduct(String keyword);
}

package com.spboot.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spboot.market.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}

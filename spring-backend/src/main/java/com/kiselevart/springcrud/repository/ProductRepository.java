package com.kiselevart.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiselevart.springcrud.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

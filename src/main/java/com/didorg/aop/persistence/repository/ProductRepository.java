package com.didorg.aop.persistence.repository;


import com.didorg.aop.persistence.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

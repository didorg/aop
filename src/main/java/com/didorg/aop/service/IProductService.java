package com.didorg.aop.service;

import com.didorg.aop.persistence.domain.Product;

import java.util.List;

public interface IProductService {
    void initDB();

    List<Product> addProduct(List<Product> products);

    List<Product> findAllProducts();
}

package com.didorg.aop.service;

import com.didorg.aop.aspect.LogExecutionTime;
import com.didorg.aop.persistence.domain.Product;
import com.didorg.aop.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void initDB() {
        // List<Product> list;
        // list = IntStream.rangeClosed(1, 10000).mapToObj(i -> new Product((long) i, "product" + i, new Random().nextInt(2000))).collect(Collectors.toList());
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(new Product((long) i, "product" + i, new Random().nextInt(2000)));
        }
        repository.saveAll(list);
    }

    @LogExecutionTime
    public List<Product> addProduct(List<Product> products) {
        return repository.saveAll(products);
    }

    @LogExecutionTime
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

}

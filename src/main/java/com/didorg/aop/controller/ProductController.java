package com.didorg.aop.controller;


import com.didorg.aop.persistence.domain.Product;
import com.didorg.aop.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/products")
public class ProductController {


    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }


    @PostMapping()
    public List<Product> saveProducts(@RequestBody List<Product> products) {

        List<Product> pList = service.addProduct(products);

        return pList;
    }

    @GetMapping()
    public List<Product> getProducts() {

        List<Product> products = service.findAllProducts();

        return products;
    }

}

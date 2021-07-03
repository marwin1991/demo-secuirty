package com.codecool.advance.demosecuirty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "p1", "d1"));
        products.add(new Product(2, "p2", "d2"));
        products.add(new Product(3, "p3", "d3"));
    }

    @GetMapping
    public List<Product> getAll(){
        return products;
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable long id){
        return products.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
    }
}

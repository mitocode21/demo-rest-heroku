package com.mitocode.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @GetMapping
    public List<Product> getAllProducts(){
        //return Arrays.asList(new Product(1, "TV"), new Product(2, "PC"));
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return repo.findById(id).orElse(new Product());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return repo.save(product);
    }
    
}

package kpmg.retail.productservice.controller;

import kpmg.retail.productservice.model.Product;
import kpmg.retail.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PostMapping("/addProductList")
    public void addProductList(@RequestBody List<Product> productList) {
        productRepository.saveAll(productList);
    }
}

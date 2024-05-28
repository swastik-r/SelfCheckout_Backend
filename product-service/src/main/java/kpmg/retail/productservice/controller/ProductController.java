package kpmg.retail.productservice.controller;

import kpmg.retail.productservice.dto.ProductResponse;
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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/allProductResponse")
    public List<ProductResponse> getAllProductResponses() {
        List<Product> products = productRepository.findAll();

        List<ProductResponse> productResponseList = products.stream().map(product -> {
            // set the sellingPricesArray for each product as an array of the selling price of the product
            Double[] sellingPricesArray ={product.getSellingPrice()};
            if (product.getSkuId() == 10003) {
                Double sellingPrice = product.getSellingPrice();
                sellingPricesArray = new Double[]{sellingPrice+100, sellingPrice+300, sellingPrice+500};
            }
            return ProductResponse.builder().product(product).sellingPriceArray(sellingPricesArray).build();
        }).collect(Collectors.toList());

        return productResponseList;
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PostMapping("/addProductList")
    public void addProductList(@RequestBody List<Product> productList) {
        productRepository.saveAll(productList);
    }

    @GetMapping("/searchByName/{searchQuery}")
    public List<Product> searchProductByName(@PathVariable String searchQuery) {
        List<Product> products1 = productRepository.findByProductNameContaining(searchQuery);
        List<Product> products2 = productRepository.findByProductBrandContaining(searchQuery);
        products1.addAll(products2);
        return products1;
    }

    @GetMapping("/searchByProductSerial/{id}")
    public List<Product> searchByProductSerial(@PathVariable String id) {
        return productRepository.findByProductSerialContaining(id);
    }
}

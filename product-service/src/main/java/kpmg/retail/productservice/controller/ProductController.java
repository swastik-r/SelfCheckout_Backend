package kpmg.retail.productservice.controller;

import kpmg.retail.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kpmg.retail.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to retrieve all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Endpoint to retrieve a product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Endpoint to add a new product
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Endpoint to add a list of new products
    @PostMapping("/addList")
    public ResponseEntity<List<Product>> addProductList(@RequestBody List<Product> products) {
        List<Product> savedProducts = productService.addProductList(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    // Endpoint to update a list of existing products
    @PutMapping("/updateList")
    public ResponseEntity<List<Product>> updateProductList(@RequestBody List<Product> products) {
        List<Product> updatedProducts = productService.updateProductList(products);
        return new ResponseEntity<>(updatedProducts, HttpStatus.OK);
    }

    // Endpoint to delete a product by ID
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

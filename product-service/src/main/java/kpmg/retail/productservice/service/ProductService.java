package kpmg.retail.productservice.service;

import kpmg.retail.productservice.model.Product;
import kpmg.retail.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Retrieve a product by ID
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    // Add a new product
    public Product addProduct(Product product) {
        // You might want to perform additional business logic/validation here
        return productRepository.save(product);
    }

    // Add a list of new products
    public List<Product> addProductList(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // Update a list of existing products
    public List<Product> updateProductList(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // Delete a product by ID
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

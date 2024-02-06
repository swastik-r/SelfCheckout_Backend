package kpmg.retail.productservice.repository;

import kpmg.retail.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(Long productId);
}

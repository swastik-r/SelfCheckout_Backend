package kpmg.retail.productservice.repository;

import kpmg.retail.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySkuId(Long skuId);
    Product findByProductSerial(String productSerial);
    List<Product> findByProductBrandContaining(String brandName);
    List<Product> findByProductNameContaining(String productName);
    List<Product> findByProductSerialContaining(String id);
}

package kpmg.retail.productservice.model;

import jakarta.persistence.Entity;
import kpmg.retail.productservice.repository.ProductRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.*;

import javax.naming.InterruptedNamingException;
import java.util.Random;

@Entity
@Data
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCT_SERIAL")
    private String product_serial;

    @Column(name = "SKU_ID")
    private Long sku_id;

    @Column(name = "PRODUCT_BRAND")
    private String product_brand;

    @Column(name = "PRODUCT_NAME")
    private String product_name;

    @Column(name = "PRODUCT_IMAGE")
    private String product_image;

    @Column(name = "PRODUCT_CATEGORY")
    private String product_category;

    @Column(name = "TAX_RATE")
    private Double tax_rate;

    @Column(name = "MRP")
    private Double mrp;

    @Column(name = "SELLING_PRICE")
    private Double selling_price;
}

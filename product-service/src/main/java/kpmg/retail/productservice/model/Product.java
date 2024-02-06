package kpmg.retail.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCT_SERIAL")
    private Long productId;

    @Column(name = "PRODUCT_BRAND")
    private String brandName;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_IMAGE")
    private String productImage;

    @Column(name = "PRODUCT_PRICE")
    private Double productPrice;

    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name = "MRP")
    private Double mrp;

    @Column(name = "SELLING_PRICE")
    private Double sellingPrice;
}

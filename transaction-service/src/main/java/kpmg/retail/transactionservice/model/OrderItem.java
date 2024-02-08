package kpmg.retail.transactionservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long oiId;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_FULL_NAME")
    private String productFullName;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "MRP")
    private Double mrp;

    @Column(name = "PRICE")
    private Double price;
}

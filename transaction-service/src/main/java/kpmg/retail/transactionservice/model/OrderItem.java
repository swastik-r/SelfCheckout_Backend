package kpmg.retail.transactionservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuffix;
    @Id
    @Column(name = "order_item_id")
    private String orderItemId = "oi" + idSuffix.toString();

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_fullName")
    private String productFullName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "mrp")
    private Double mrp;

    @Column(name = "price")
    private Double price;
}

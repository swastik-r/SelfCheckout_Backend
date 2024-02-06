package kpmg.retail.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mmrp")
public class MMRP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mmrp_id")
    private Long mmrpId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "mrp")
    private Double mrp;

    @Column(name = "price")
    private Double price;
}


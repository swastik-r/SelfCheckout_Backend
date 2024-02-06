package kpmg.retail.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "tax_rate")
    private Double taxRate;
}


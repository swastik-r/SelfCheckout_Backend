package kpmg.retail.productservice.dto;

import kpmg.retail.productservice.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Product product;
    private Double[] sellingPriceArray;
}

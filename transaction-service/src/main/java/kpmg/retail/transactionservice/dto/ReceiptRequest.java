package kpmg.retail.transactionservice.dto;

import jakarta.persistence.Entity;
import lombok.Data;
import kpmg.retail.transactionservice.model.OrderItem;

import java.util.List;

@Data
public class ReceiptRequest {
    List<OrderItem> orderItemsList;
    Double tax;
    Double grandTotal;
}

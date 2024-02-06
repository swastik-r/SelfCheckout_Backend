package kpmg.retail.transactionservice.service;

import kpmg.retail.transactionservice.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    public String generateReceipt(List<OrderItem> orderItems, Double tax, Double grandTotal) {
        StringBuilder receipt = new StringBuilder("Receipt\n");
        for (OrderItem item : orderItems) {
            receipt.append(item.getProductId())
                    .append(" ")
                    .append(item.getProductFullName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" ")
                    .append(item.getPrice())
                    .append("\n");
        }
        receipt.append("Tax: ₹")
                .append(tax)
                .append("\n");
        receipt.append("Total: ₹")
                .append(grandTotal)
                .append("\n");
        return receipt.toString();
    }
}

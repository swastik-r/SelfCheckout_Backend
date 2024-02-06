package kpmg.retail.transactionservice.controller;

import kpmg.retail.transactionservice.dto.ReceiptRequest;
import kpmg.retail.transactionservice.model.OrderItem;
import kpmg.retail.transactionservice.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReceipt(@RequestBody ReceiptRequest receiptRequest){
        List<OrderItem> orderItems = receiptRequest.getOrderItemsList();
        Double tax = receiptRequest.getTax();
        Double grandTotal = receiptRequest.getGrandTotal();
        String receipt = receiptService.generateReceipt(orderItems, tax, grandTotal);
        return ResponseEntity.ok(receipt);
    }
}

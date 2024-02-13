package kpmg.retail.transactionservice.model;

import jakarta.persistence.*;
import kpmg.retail.transactionservice.repository.TransactionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    private String transactionId = "TRX" + new Random().nextInt(1000000);
    
    @Column(name = "created_at")
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    @Column(name = "user_id")
    private String userId;

    @Column(name = "encrypted_mobile")
    private String encryptedMobile;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "error_message")
    private String errorMessage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transaction_id")
    private List<OrderItem> orderItems;
}
package kpmg.retail.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_encrypted_mobile")
    private String encryptedMobile;

    @Column(name = "user_lpBalance")
    private Integer loyaltyPoints;

    @Column(name = "user_feedback")
    private Double feedbackAvg;

    @Column(name = "user_role")
    private String role;
}

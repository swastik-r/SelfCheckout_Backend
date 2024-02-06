package kpmg.retail.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "encrypted_mobile")
    private String encryptedMobile;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @Column(name = "feedback_avg")
    private Double feedbackAvg;
}


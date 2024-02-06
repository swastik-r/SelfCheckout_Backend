package kpmg.retail.userservice.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "feedbacks")
public class FeedbackRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuffix;
    @Id
    @Column(name = "feedback_id")
    private String serialNumber = "fb" + idSuffix;

    @Column(name = "timestamp")
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "rating")
    private Double rating;
}

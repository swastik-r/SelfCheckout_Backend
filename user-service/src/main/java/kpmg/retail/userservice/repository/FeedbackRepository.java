package kpmg.retail.userservice.repository;

import kpmg.retail.userservice.dto.FeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackRequest, Long> {
}

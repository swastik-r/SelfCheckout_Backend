package kpmg.retail.userservice.dto;

import lombok.Data;

@Data
public class LoyaltyPointsUpdateRequest {
    private Long userId;
    private Integer pointsEarned;
    private Boolean hasRedeemed;
}

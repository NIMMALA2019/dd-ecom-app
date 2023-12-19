package com.ntreddy.dd.ecommerce.dto.response.catalog;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponse {
    private Long id;
    private Long customerId;
    private String text;
    private Short rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

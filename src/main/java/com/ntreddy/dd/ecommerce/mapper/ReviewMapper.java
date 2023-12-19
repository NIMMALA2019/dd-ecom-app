package com.ntreddy.dd.ecommerce.mapper;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.catalog.ReviewRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ReviewResponse;
import com.ntreddy.dd.ecommerce.entity.Review;
import com.ntreddy.dd.ecommerce.service.catalog.ReviewService;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private ReviewService reviewService;

    public ReviewResponse create(ReviewRequest review) {
        Review r = basicMapper.convertTo(review, Review.class);
        return basicMapper.convertTo(reviewService.create(review.getProductId(), r), ReviewResponse.class);
    }

    public ReviewResponse update(Long reviewId, ReviewRequest review) {
        Review r = basicMapper.convertTo(review, Review.class);
        return basicMapper.convertTo(reviewService.update(reviewId, review.getProductId(), r), ReviewResponse.class);
    }

    public ReviewResponse getById(Long reviewId) {
        return basicMapper.convertTo(reviewService.getById(reviewId), ReviewResponse.class);
    }

    public Page<ReviewResponse> getByProductId(Long productId, Pageable pageable) {
        return reviewService.getByProductId(productId, pageable).map(review -> basicMapper.convertTo(review, ReviewResponse.class));
    }

    public Page<ReviewResponse> getByCustomerId(Long customerId, Pageable pageable) {
        return reviewService.getByCustomerId(customerId, pageable).map(review -> basicMapper.convertTo(review, ReviewResponse.class));
    }

    public void deleteById(Long reviewId) {
        reviewService.deleteById(reviewId);
    }
}

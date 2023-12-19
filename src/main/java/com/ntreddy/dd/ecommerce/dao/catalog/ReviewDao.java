package com.ntreddy.dd.ecommerce.dao.catalog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.Review;

public interface ReviewDao {

	List<Review> getReviews(Long productId);

	int create(Review review, Product product);

	Review findById(Long reviewId);

	Page<Review> findByProduct_Id(Long productId, Pageable pageable);

	Page<Review> findByCustomerId(Long customerId, Pageable pageable);

	void deleteById(Long reviewId);

}

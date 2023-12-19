package com.ntreddy.dd.ecommerce.dao.impl.catalog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.dao.catalog.ReviewDao;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Override
	public List<Review> getReviews(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Review review, Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Review findById(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Review> findByProduct_Id(Long productId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Review> findByCustomerId(Long customerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long reviewId) {
		// TODO Auto-generated method stub
		
	}

}

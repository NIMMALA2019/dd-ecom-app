package com.ntreddy.dd.ecommerce.serviceImpl.catalog;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.dao.catalog.ReviewDao;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.Review;
import com.ntreddy.dd.ecommerce.service.catalog.ProductService;
import com.ntreddy.dd.ecommerce.service.catalog.ReviewService;
import com.ntreddy.dd.ecommerce.util.UpdatingUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewDao reviewDao;
//    @Autowired
//    private CustomerClient customerClient;
    @Autowired
    private ProductService productService;

    @Override
    public Review create(Long productId, Review review) {
//        customerClient.getById(review.getCustomerId()); // If customer doesn't exist feign will throw an exception
        Product product = productService.getById(productId);
        List<Review> reviews = reviewDao.getReviews(productId);
        reviews.add(review);
        int sum = reviews.stream().mapToInt(Review::getRating).sum();
        float average = (float) sum / (float) reviews.size();
        product.setAverageStar(average);
        int id=  reviewDao.create(review,product);
        return  getById(Long.valueOf(id));
        
    }

    @Override
    public Review update(Long reviewId, Long productId, Review review) {
        Review oldReview = getById(reviewId);
        BeanUtils.copyProperties(review, oldReview, UpdatingUtil.getNullPropertyNames(review));
        return create(productId, oldReview);
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewDao.findById(reviewId);
    }

    @Override
    public Page<Review> getByProductId(Long productId, Pageable pageable) {
        return reviewDao.findByProduct_Id(productId, pageable);
    }

    @Override
    public Page<Review> getByCustomerId(Long customerId, Pageable pageable) {
        return reviewDao.findByCustomerId(customerId, pageable);
    }

    @Override
    public void deleteById(Long reviewId) {
    	reviewDao.deleteById(reviewId);
    }
}

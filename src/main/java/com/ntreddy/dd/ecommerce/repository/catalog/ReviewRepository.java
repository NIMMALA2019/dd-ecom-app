//package com.ntreddy.dd.ecommerce.repository.catalog;
//
//import com.ntreddy.dd.ecommerce.entity.Review;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ReviewRepository extends JpaRepository<Review, Long> {
//    Page<Review> findByProduct_Id(Long productId, Pageable pageable);
//    Page<Review> findByCustomerId(Long customerId, Pageable pageable);
//}

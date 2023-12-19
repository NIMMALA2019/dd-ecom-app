//package com.ntreddy.dd.ecommerce.repository.catalog;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.ntreddy.dd.ecommerce.entity.Category;
//
//@Repository
//public interface CategoryRepository extends JpaRepository<Category, Long> {
//    @Query("SELECT c FROM Category c WHERE c.level = 1")
//    List<Category> findAll();
//}

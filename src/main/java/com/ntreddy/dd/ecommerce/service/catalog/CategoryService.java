package com.ntreddy.dd.ecommerce.service.catalog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.Category;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.util.Pagination;

public interface CategoryService {
    Category create(Category category);
    List<Category> getAll(Pagination page);
    Category getCategoryById(Long id);
    Page<Product> getProductsByCategory(Long categoryId, Pageable pageable);
//    Category setParentCategory(Long parentId, Category category);
//    Category updateCategory(Long id, Long parentCategoryId, Category updatedCategory);
    Category updateCategory(Long id, Category updatedCategory);
    void deleteCategory(Long id);
//    void deleteBanner(Long id);
//    Category uploadBanners(Long id, MultipartFile[] banners);
//	Page<ProductResponse> getProductsByCategory(Long id, Pageable pageable);
}

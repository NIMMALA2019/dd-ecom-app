package com.ntreddy.dd.ecommerce.dao.catalog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.Category;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.util.Pagination;

public interface CategoryDao {

	Long createCategory(Category category);

	Category findById(Long id);

	List<Category> findAll(Pagination page);

	Page<Product> findAllByCategory_Id(Long categoryId, Pageable pageable);

	int update(Long id, Category updatedCategory);

	int deleteById(Long id);

}

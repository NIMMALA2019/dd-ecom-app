package com.ntreddy.dd.ecommerce.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.catalog.CategoryRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.CategoryResponse;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.entity.Category;
import com.ntreddy.dd.ecommerce.service.catalog.CategoryService;
import com.ntreddy.dd.ecommerce.util.Pagination;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private CategoryService categoryService;

    public List<CategoryResponse> getCategories(Pagination page) {
        return basicMapper.convertListTo(categoryService.getAll(page), CategoryResponse.class);
    }
    
//    public Page<CategoryResponse> getCategories() {
//        return basicMapper.convertListTo(categoryService.getAll(), CategoryResponse.class);
//    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = basicMapper.convertTo(categoryRequest, Category.class);
        return basicMapper.convertTo(categoryService.create(category), CategoryResponse.class);
    }

    public CategoryResponse getById(Long id) {
        return basicMapper.convertTo(categoryService.getCategoryById(id), CategoryResponse.class);
    }

//    public Page<ProductResponse> getProductsByCategoryId(Long id, Pageable pageable) {
//        return categoryService.getProductsByCategory(id, pageable).map(product -> basicMapper.convertTo(product, ProductResponse.class));
//    }

    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryService.updateCategory(id, basicMapper.convertTo(categoryRequest, Category.class));
        return basicMapper.convertTo(category, CategoryResponse.class);
    }

//    public void deleteBanner(Long id) {
//        categoryService.deleteBanner(id);
//    }
//
    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }

//    public CategoryResponse uploadBanners(Long id, MultipartFile[] banners) {
//        return basicMapper.convertTo(categoryService.uploadBanners(id, banners), CategoryResponse.class);
//    }

//	public Page<CategoryResponse> findpagenated(int page, int size) {
//		return basicMapper.convertTo(categoryService.findpagenated(page, size), CategoryResponse.class);
//	}
}

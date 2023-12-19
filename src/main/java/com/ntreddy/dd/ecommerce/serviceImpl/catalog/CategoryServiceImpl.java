package com.ntreddy.dd.ecommerce.serviceImpl.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.dao.catalog.CategoryDao;
import com.ntreddy.dd.ecommerce.entity.Category;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.service.catalog.CategoryService;
import com.ntreddy.dd.ecommerce.util.Pagination;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

//	@Autowired
//    private CategoryRepository categoryRepository;
//	@Autowired
//    private ProductRepository productRepository;
//	@Autowired
//    private BannerRepository bannerRepository;
//    private final ImageClient imageClient;

	@Autowired
	private CategoryDao categorydao;
	
	@Override
    public Category create(Category category) {
		Long id= categorydao.createCategory(category);
		return categorydao.findById(id);
//		return categorydao.findById(id).orElseThrow(() -> new NoSuchElementException("Category not found"));
    }
	
	
//    @Override
//    public Category create(Category category) {
//        return categoryRepository.save(category);
//    }

    @Override
    public List<Category> getAll(Pagination page) {
        return categorydao.findAll(page);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categorydao.findById(id);
//        return categorydao.findById(id).orElseThrow(() -> new NoSuchElementException("Category not found"));
    }

    @Override
    public Page<Product> getProductsByCategory(Long categoryId, Pageable pageable) {
        return categorydao.findAllByCategory_Id(categoryId, pageable);
    }
//
//    @Override
//    public Category setParentCategory(Long parentId, Category category) {
////        if(parentId != null) {
////            Category parentCategory = getCategoryById(parentId);
////            category.setParentCategory(parentCategory);
////            if(parentCategory.getLevel() == 3) {
////                throw new CategoryLevelException("You cannot choose this category as parent because his level is 3");
////            }
////            category.setLevel(parentCategory.getLevel() + 1);
////        } else {
////            category.setLevel(1);
////        }
//        return category;
//    }
//
//    private Category update(Long id, Category updatedCategory) {
//        Category category = getCategoryById(id);
////        category.setName(updatedCategory.getName());
//        return category;
//    }
//
//    @Override
//    public Category updateCategory(Long id, Long parentCategoryId, Category updatedCategory) {
//        Category category = update(id, updatedCategory);
//        setParentCategory(parentCategoryId, category);
//
////      Remove child from old parent category
////        Category oldParent = category.getParentCategory().removeChild(category.getId());
////        categoryRepository.save(oldParent);
//
//        return categoryRepository.save(category);
//    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        int i= categorydao.update(id,updatedCategory);
        if(i>0)
        	return categorydao.findById(id);
        else
        	return null;
    }

    @Override
    public void deleteCategory(Long id) {
       int i= categorydao.deleteById(id);
    }
//
//    @Override
//    public void deleteBanner(Long id) {
//        bannerRepository.deleteById(id);
//    }
//
//    private List<Banner> uploadAndReturnBanners(Category category, MultipartFile[] banners) {
//        List<Banner> bannerList = new ArrayList<>();
////        for (MultipartFile banner : banners) {
////            String fileSrc = imageClient.uploadImage(banner);
////            Banner bnr = bannerRepository.save(new Banner(fileSrc, category));
////            bannerList.add(bnr);
////        }
//        return bannerList;
//    }
//
//    @Override
//    public Category uploadBanners(Long id, MultipartFile[] banners) {
//        Category category = getCategoryById(id);
////        if(category.getLevel() != 1) {
////            throw new IllegalArgumentException("A category must have 1 level");
////        }
////        if(category.getBanners().size() >= 3) {
////            throw new IllegalArgumentException("A category can have only 3 banners");
////        }
////        List<Banner> uploadedBanners = uploadAndReturnBanners(category, banners);
////        category.setBanners(uploadedBanners);
//        return category;
//    }

	
}

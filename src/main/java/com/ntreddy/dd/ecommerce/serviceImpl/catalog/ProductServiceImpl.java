package com.ntreddy.dd.ecommerce.serviceImpl.catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dao.catalog.ProductDao;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.ProductImage;
import com.ntreddy.dd.ecommerce.service.catalog.CategoryService;
import com.ntreddy.dd.ecommerce.service.catalog.ProductService;
import com.ntreddy.dd.ecommerce.util.Pagination;
import com.ntreddy.dd.ecommerce.util.UpdatingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final int MIN_REVIEWS = 10;
    private static final int NORMALIZATION_FACTOR = 100;

//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private ProductImageRepository productImageRepository;
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductDao productDao;
    
    
//    private final ImageClient imageClient;

    private static Float calculatePopularityScore(Product product) {
//        Float avgRating = product.getAverageStar();
//        int numReviews = product.getReviews().size();
    	  Float avgRating = 1.0f;
          int numReviews=222;

        return (MIN_REVIEWS / (MIN_REVIEWS + (float)numReviews)) * avgRating
                + (numReviews / (MIN_REVIEWS + (float)numReviews)) * NORMALIZATION_FACTOR;
    }

    private Comparator<Product> getProductComparator() {
        return (p1, p2) -> {
            Float p1Score = calculatePopularityScore(p1);
            Float p2Score = calculatePopularityScore(p2);
            return p2Score.compareTo(p1Score);
        };
    }

    @Override
	public ProductResponse uploadProductImage(MultipartFile[] images, Long productId) {
        List<ProductImage> productImages = new ArrayList<>();
        ProductImage img=new ProductImage();
        byte[]src=null;
        for (MultipartFile image : images) {
        	try {
				src=UpdatingUtil.compressBytes(image.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
        	img.setSrc(src);
        	img.setProduct_id(productId);
        	productImages.add(img);
        }
        int batchInsert[][]= productDao. uploadProductImage(productImages,images.length);
        System.out.println(batchInsert);
        return null;
    }

    @Override
    public Product create(Product product) {
        Long productId= productDao.createProduct(product);
        return productDao.findById(productId);
    }

    @Override
    public Product update(Long productId, Product product, Long categoryId) {
    	 int i= productDao.update(productId,product);
         if(i>0)
         	return productDao.findById(productId);
         else
         	return null;
    }
//
//    @Override
//    public Product update(Product product) {
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Product uploadImages(MultipartFile[] images, Long productId) {
//        Product product = getById(productId);
//        product.setImages(uploadProductImage(images, product));
//        return product;
//    }
//
//    @Override
//    @Transactional
//    public void updateOrderCount(Long productId, boolean increase) {
//        productRepository.updateOrderCount(productId, increase);
//    }

    @Override
    public List<Product> getAll(Pagination pageable) {
//        Sort sort = pageable.getSort();
//        if(!sort.isEmpty() &&
//           sort.iterator().next().getProperty().equals("popularity")
//        ) {
//            List<Product> products = productRepository.findAll(pageable).stream()
//                    .sorted(getProductComparator())
//                    .toList();
//            return new PageImpl<>(products, pageable, products.size());
//        }
//        
//        List<Product> products = productDao.findAll(pageable).stream()
//                .sorted(getProductComparator())
//                .toList();
//        return new JdbcPage<Product>(products, pageable, products.size());
        return productDao.findAll(pageable);
    }

    @Override
    public Product getById(Long productId) {
        return productDao.findById(productId);
    }

    @Override
    public void deleteProduct(Long productId) {
    	int id=productDao.deleteById(productId);
    }

}

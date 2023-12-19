package com.ntreddy.dd.ecommerce.service.catalog;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.util.Pagination;

public interface ProductService {
    Product create(Product product);
    Product update(Long productId, Product product, Long categoryId);
//    Product update(Product product);
    ProductResponse uploadProductImage(MultipartFile[] images, Long productId);
//    void updateOrderCount(Long productId, boolean increase);
    List<Product> getAll(Pagination pageable);
    Product getById(Long productId);
    void deleteProduct(Long productId);
}

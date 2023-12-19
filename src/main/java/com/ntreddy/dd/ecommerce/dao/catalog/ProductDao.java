package com.ntreddy.dd.ecommerce.dao.catalog;

import java.util.List;

import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.ProductImage;
import com.ntreddy.dd.ecommerce.util.Pagination;

public interface ProductDao {

	List<Product> findAll(Pagination pageable);

	Long createProduct(Product product);

	Product findById(Long productId);

	int[][] uploadProductImage(List<ProductImage> productImages, int batchSize);

	int deleteById(Long productId);

	int update(Long productId, Product product);

	void updateOrdersCount(Long productId, boolean b);

}

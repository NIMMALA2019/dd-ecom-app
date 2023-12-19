package com.ntreddy.dd.ecommerce.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dto.request.catalog.ProductRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.service.catalog.ProductService;
import com.ntreddy.dd.ecommerce.util.Pagination;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private ProductService productService;

    public List<ProductResponse> getProducts(Pagination page) {
    	return basicMapper.convertListTo(productService.getAll(page), ProductResponse.class);
//        return productService.getAll(page).map(product -> basicMapper.convertTo(product, ProductResponse.class));
    }

    public ProductResponse getProductById(Long productId) {
        return basicMapper.convertTo(productService.getById(productId), ProductResponse.class);
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productService.create(basicMapper.convertTo(productRequest, Product.class));
        return basicMapper.convertTo(product, ProductResponse.class);
    }

    public ProductResponse uploadImages(MultipartFile[] images, Long productId) {
        return basicMapper.convertTo(productService.uploadProductImage(images, productId), ProductResponse.class);
    }

    public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {
        Product product = productService.update(productId, basicMapper.convertTo(productRequest, Product.class), productRequest.getCategory_id());
        return basicMapper.convertTo(product, ProductResponse.class);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
}

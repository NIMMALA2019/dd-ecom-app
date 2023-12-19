package com.ntreddy.dd.ecommerce.controller.catalog;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ALL;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATALOG;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.PRODUCTS;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.PRODUCT_ID;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.UPLOAD;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dto.request.catalog.ProductRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.mapper.ProductMapper;
import com.ntreddy.dd.ecommerce.util.Pagination;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1+CATALOG+PRODUCTS)
@Tag(name = "Product Controller")
public class ProductController {

   @Autowired
   private ProductMapper productMapper;

   	@GetMapping(ALL)
	@Operation(summary = "Get a paginated list of products", description = "Returns a paginated list of all products")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products"),
	        @ApiResponse(responseCode = "500", description = "Internal server error")
	})
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam(value = "page", defaultValue = "1") Long page,
															 @RequestParam(value = "size", defaultValue = "10") Long size) {
   		return ResponseEntity.ok(productMapper.getProducts(Pagination.of(page, size)));
    }

    @GetMapping(PRODUCT_ID)
    @Operation(summary = "Get a product by ID", description = "Returns a single product identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productMapper.getProductById(productId));
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(ADD)
    @Operation(summary = "Create a new product", description = "Creates a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created product"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productMapper.createProduct(productRequest));
    }
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(PRODUCT_ID+UPLOAD)
    @Operation(summary = "Upload new images for a product", description = "Upload new images for a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully uploaded images"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ProductResponse> uploadImage(@RequestParam("images") MultipartFile[] images, @PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productMapper.uploadImages(images, productId));
    }
//
//    @PutMapping("/{productId}/orders/count/{increase}")
//    @Operation(summary = "Update orders count in product", description = "Update orders count in product by product ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully updated orders count"),
//            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
//    })
//    public void updateOrderCount(@PathVariable("productId") Long productId, @PathVariable("increase") boolean increase) {
//        productService.updateOrderCount(productId, increase);
//    }
//
//
    @PutMapping(PRODUCT_ID)
    @Operation(summary = "Update product", description = "Update a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("productId") Long productId,
                                                         @Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productMapper.updateProduct(productId, productRequest));
    }

    @DeleteMapping(PRODUCT_ID)
    @Operation(summary = "Delete a product by id", description = "Delete a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productMapper.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.ntreddy.dd.ecommerce.controller.catalog;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ALL;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATALOG;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATEGORY;

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

import com.ntreddy.dd.ecommerce.dto.request.catalog.CategoryRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.CategoryResponse;
import com.ntreddy.dd.ecommerce.mapper.CategoryMapper;
import com.ntreddy.dd.ecommerce.util.Pagination;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1+CATALOG+CATEGORY)
//@RequestMapping("/api/v1/catalog/categories")
@Tag(name = "Category Controller")
public class CategoryController {

	@Autowired
    private CategoryMapper categoryMapper;
	
    @GetMapping(ALL)
    @Operation(summary = "Get All Categories", description = "Retrieve all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of categories"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<List<CategoryResponse>> getCategories(@RequestParam(value = "page", defaultValue = "1") Long page,
            													@RequestParam(value = "size", defaultValue = "5") Long size) {
        return ResponseEntity.ok(categoryMapper.getCategories(Pagination.of(page, size)));
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(ADD)
    @Operation(summary = "Create a new category", description = "Create a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(categoryMapper.createCategory(categoryRequest));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a category by ID", description = "Returns a single category identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the category"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CategoryResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryMapper.getById(id));
    }
//
//    @GetMapping("/{id}/products")
//    @Operation(summary = "Get Products by Category ID", description = "Retrieve all products belonging to a category")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully retrieved the products"),
//            @ApiResponse(responseCode = "404", description = "Category not found"),
//            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
//    })
//    public ResponseEntity<Page<ProductResponse>> getProductsByCategoryId(@PathVariable("id") Long id, @PageableDefault Pageable pageable) {
//        return ResponseEntity.ok(categoryMapper.getProductsByCategoryId(id, pageable));
//    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Category", description = "Update a category by its ID")
    @ApiResponses(value = {//            @ApiResponse(responseCode = "200", description = "Category updated"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(categoryMapper.updateCategory(id, categoryRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category by id", description = "Delete a category by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryMapper.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//
////    Banner
//
//    @PostMapping("/{id}/banner")
//    @Operation(summary = "Upload a banners to category", description = "Upload a banners to category by its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Banner uploaded"),
//            @ApiResponse(responseCode = "404", description = "Category not found"),
//            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
//    })
//    public ResponseEntity<CategoryResponse> uploadBanners(@PathVariable("id") Long id, @RequestParam("Banners") MultipartFile[] banners) {
//        return ResponseEntity.ok(categoryMapper.uploadBanners(id, banners));
//    }
//
//    @DeleteMapping("/banner/{id}")
//    @Operation(summary = "Delete a banner by id", description = "Delete a banner by its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Banner deleted"),
//            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
//    })
//    public ResponseEntity<Void> deleteBanner(@PathVariable("id") Long id) {
//        categoryMapper.deleteBanner(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    
}

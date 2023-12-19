package com.ntreddy.dd.ecommerce.controller.catalog;


import static com.ntreddy.dd.ecommerce.constants.PathConstants.ADD;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.CATALOG;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.ID;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.REVIWES;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.request.catalog.ReviewRequest;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ReviewResponse;
import com.ntreddy.dd.ecommerce.mapper.ReviewMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1+CATALOG+REVIWES)
@Tag(name = "Review Controller")
public class ReviewController {

	@Autowired
    private ReviewMapper reviewMapper;

    @PostMapping(ADD)
    @Operation(summary = "Create a new review", description = "Create a new review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ReviewResponse> create(@Valid @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok(reviewMapper.create(reviewRequest));
    }

    @GetMapping(ID)
    @Operation(summary = "Get a review by ID", description = "Returns a single review identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the review"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ReviewResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reviewMapper.getById(id));
    }

    @GetMapping("/product"+ID)
    @Operation(summary = "Get Reviews by Product ID", description = "Retrieve all reviews belonging to a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the reviews"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<Page<ReviewResponse>> getByProductId(@PathVariable("id") Long id, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(reviewMapper.getByProductId(id, pageable));
    }

    @GetMapping("/customer"+ID)
    @Operation(summary = "Get Reviews by Customer ID", description = "Retrieve all reviews belonging to a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the reviews"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<Page<ReviewResponse>> getByCustomerId(@PathVariable("id") Long id, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(reviewMapper.getByCustomerId(id, pageable));
    }

    @PutMapping(ID)
    @Operation(summary = "Update Review", description = "Update a review by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review updated"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable("id") Long id, @Valid @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok(reviewMapper.update(id, reviewRequest));
    }

    @DeleteMapping(ID)
    @Operation(summary = "Delete a review by id", description = "Delete a review by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Review deleted"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<Void> deleteReview(@PathVariable("id") Long id) {
        reviewMapper.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

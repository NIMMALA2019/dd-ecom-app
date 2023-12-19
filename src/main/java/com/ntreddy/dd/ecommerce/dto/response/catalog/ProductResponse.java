package com.ntreddy.dd.ecommerce.dto.response.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ntreddy.dd.ecommerce.dto.response.catalog.CategoryResponse;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponse {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    @JsonIgnoreProperties("products")
    private CategoryResponse category;
    private List<ProductImageResponse> images;
    private Float averageStar;
    private Integer ordersCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CategoryResponse getCategory() {
		return category;
	}
	public void setCategory(CategoryResponse category) {
		this.category = category;
	}
	public List<ProductImageResponse> getImages() {
		return images;
	}
	public void setImages(List<ProductImageResponse> images) {
		this.images = images;
	}
	public Float getAverageStar() {
		return averageStar;
	}
	public void setAverageStar(Float averageStar) {
		this.averageStar = averageStar;
	}
	public Integer getOrdersCount() {
		return ordersCount;
	}
	public void setOrdersCount(Integer ordersCount) {
		this.ordersCount = ordersCount;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
    
}

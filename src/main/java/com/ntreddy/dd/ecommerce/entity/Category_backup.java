//package com.ntreddy.dd.ecommerce.entity;
//
//import javax.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "category")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Category_backup {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "level", nullable = false)
//    private Integer level;
//
//    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Category_backup> childCategories = new HashSet<>();
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id", columnDefinition = "integer default null")
//    private Category_backup parentCategory = null;
//
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Banner> banners = new ArrayList<>();
//
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Product> products = new HashSet<>();
//
//    @CreationTimestamp
//    @Column(name = "createdAt")
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updatedAt")
//    private LocalDateTime updatedAt;
//
//    public Category_backup removeChild(Long childId) {
//        this.childCategories.removeIf(ch -> ch.getId().equals(childId));
//        return this;
//    }
//
//    public void removeProduct(Long productId) {
//        this.products.removeIf(p -> p.getId().equals(productId));
//    }
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Integer getLevel() {
//		return level;
//	}
//
//	public void setLevel(Integer level) {
//		this.level = level;
//	}
//
//	public Set<Category_backup> getChildCategories() {
//		return childCategories;
//	}
//
//	public void setChildCategories(Set<Category_backup> childCategories) {
//		this.childCategories = childCategories;
//	}
//
//	public Category_backup getParentCategory() {
//		return parentCategory;
//	}
//
//	public void setParentCategory(Category_backup parentCategory) {
//		this.parentCategory = parentCategory;
//	}
//
//	public List<Banner> getBanners() {
//		return banners;
//	}
//
//	public void setBanners(List<Banner> banners) {
//		this.banners = banners;
//	}
//
//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
//
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//    
//    
//}

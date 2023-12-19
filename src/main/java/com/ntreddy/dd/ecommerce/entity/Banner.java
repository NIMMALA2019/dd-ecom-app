//package com.ntreddy.dd.ecommerce.entity;
//
//import javax.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "banners")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Banner {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "src", nullable = false)
//    private String src;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category_backup category;
//
//    @CreationTimestamp
//    @Column(name = "createdAt")
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updatedAt")
//    private LocalDateTime updatedAt;
//
//    public Banner(String src, Category_backup category) {
//        this.src = src;
//        this.category = category;
//    }
//}

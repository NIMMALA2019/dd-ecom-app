package com.ntreddy.dd.ecommerce.entity;

import java.sql.Blob;

public class ProductImage {
    private Long id;
    private byte[] src;
    private Long product_id;

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSrc() {
		return src;
	}

	public void setSrc(byte[] src) {
		this.src = src;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	

    
}

package com.ntreddy.dd.ecommerce.dto.request.catalog;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {
    @Size(min = 3, max = 25, message = "Name must be between 3 and 30 characters")
    @NotBlank(message = "Name value mustn't be null or whitespace")
    private String name;
    private Long id;
    private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
    
    
    

    
    
    
}
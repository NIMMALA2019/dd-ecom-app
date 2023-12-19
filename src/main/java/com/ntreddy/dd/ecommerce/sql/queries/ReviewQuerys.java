package com.ntreddy.dd.ecommerce.sql.queries;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:querys.properties")
public class ReviewQuerys {
	@Value("${category.query.find.by.id}")
    private String findById;
    @Value("${category.query.delete.by.id}")
    private String deleteById;
    @Value("${category.query.update}")
    private String update;
    @Value("${category.query.find.all}")
    private String findAll;
    @Value("${category.query.insert}")
    private String insert;

	    public String getFindById() {
	        return findById;
	    }

	    public String getDeleteById() {
	        return deleteById;
	    }

	    public String getUpdate() {
	        return update;
	    }

	    public String getFindAll() {
	        return findAll;
	    }
	    public String getInsert() {
	        return insert;
	    }

}

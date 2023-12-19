package com.ntreddy.dd.ecommerce.sql.queries;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:querys.properties")
public class ProductQuerys {

	@Value("${product.query.find.by.id}")
    private String findById;
    @Value("${product.query.delete.by.id}")
    private String deleteById;
    @Value("${product.query.update}")
    private String update;
    @Value("${product.query.find.all}")
    private String findAll;
    @Value("${product.query.insert}")
    private String insert;
    @Value("${product.query.find.count}")
    private String count;

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

		public String getCount() {
			return count;
		}
	    
	    


}

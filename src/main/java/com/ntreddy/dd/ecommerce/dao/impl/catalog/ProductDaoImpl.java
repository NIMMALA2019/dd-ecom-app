package com.ntreddy.dd.ecommerce.dao.impl.catalog;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntreddy.dd.ecommerce.dao.catalog.ProductDao;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.entity.ProductImage;
import com.ntreddy.dd.ecommerce.sql.queries.ProductQuerys;
import com.ntreddy.dd.ecommerce.util.Pagination;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductQuerys sql;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Product> findAll(Pagination pageable) {
		
		System.out.println(pageable.getLimit()+"---"+pageable.getOffset());
		
//		@SuppressWarnings("unused")
//		int count =
//              jdbcTemplate.queryForObject(
//                      sql.getCount(),
//                      new Object[]{}, (rs, rowNum) -> rs.getInt(1)
//              );
//		System.out.println("count---"+count);
		
		@SuppressWarnings("deprecation")
		List<Product> allProduct = jdbcTemplate.query(
                sql.getFindAll(),new Object[] {pageable.getLimit(),pageable.getOffset()},
                new BeanPropertyRowMapper<Product>(Product.class));
		System.out.println(pageable.toString());
		
		
//		return new JdbcPage<Product>(allProduct, pageable, total);
		
        return allProduct;
	}

	@Override
	@Transactional
	public Long createProduct(Product product) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
	    System.out.println(sql.getInsert());    
        int rowsAffected = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql.getInsert(), Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setInt(4,  product.getQuantity());
            preparedStatement.setLong(5,  product.getCategory_id());
            preparedStatement.setInt(6,  product.getOrdersCount());
            preparedStatement.setObject(7, LocalDateTime.now());
            return preparedStatement;
        }, generatedKeyHolder);
        // Get auto-incremented ID
        Integer id = generatedKeyHolder.getKey().intValue();
        System.out.println("rowsAffected = {}, id={}"+rowsAffected+"---"+ id);
        return (Long) generatedKeyHolder.getKey().longValue();
	}

	@SuppressWarnings({ "deprecation"})
	@Override
	public Product findById(Long productId) {
		return (Product) jdbcTemplate.queryForObject(
				 sql.getFindById(), 
					new Object[]{productId}, 
					new BeanPropertyRowMapper<Product>(Product.class));
	}
	
	
	@Transactional
    public int[][] uploadProductImage(List<ProductImage> books, int batchSize) {
        int[][] updateCounts = jdbcTemplate.batchUpdate(
                "insert into books (name, price) values(?,?)",
                books,
                batchSize,
                new ParameterizedPreparedStatementSetter<ProductImage>() {
                    public void setValues(PreparedStatement ps, ProductImage argument) throws SQLException {
                        ps.setBytes(1, argument.getSrc());
                        ps.setLong(2, argument.getProduct_id());
                    }
                });
        return updateCounts;
    }
	
	@Override
	public int update(Long id, Product product) {
		 return jdbcTemplate.update(sql.getUpdate(),
			        new Object[] { 
			        		product.getProductName(),
			        		product.getDescription(),
			        		product.getPrice(),
			        		product.getQuantity(),
			        		LocalDateTime.now(),id});
	}
	
	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(sql.getDeleteById(), id);
	}

	@Override
	public void updateOrdersCount(Long productId, boolean b) {
		// TODO Auto-generated method stub
		
	}
}

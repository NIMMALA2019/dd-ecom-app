package com.ntreddy.dd.ecommerce.dao.impl.cart;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.dao.cart.CartDao;
import com.ntreddy.dd.ecommerce.entity.Cart;
import com.ntreddy.dd.ecommerce.sql.queries.CartQuerys;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private CartQuerys sql;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Long save(Cart cart) {
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
	    System.out.println(sql.getCartInsert());    
        int rowsAffected = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql.getCartInsert(), Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setLong(1, cart.getCustomer_id());
            preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
            return preparedStatement;
        }, generatedKeyHolder);
        // Get auto-incremented ID
        Integer id = generatedKeyHolder.getKey().intValue();
        System.out.println("rowsAffected = {}, id={}"+rowsAffected+"---"+ id);
        return (Long) generatedKeyHolder.getKey().longValue();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Cart findByCartId(Long id) {
		return (Cart) jdbcTemplate.queryForObject(
			sql.getFindById(), 
			new Object[]{id}, 
			new BeanPropertyRowMapper<Cart>(Cart.class));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Cart findByCustomerId(Long id) {
		return (Cart) jdbcTemplate.queryForObject(
			sql.getFindById(), 
			new Object[]{id}, 
			new BeanPropertyRowMapper<Cart>(Cart.class));
    }

	@Override
	public void deleteByCustomerId(Long id) {
		 jdbcTemplate.update(sql.getDeleteById(), id);
	}

}

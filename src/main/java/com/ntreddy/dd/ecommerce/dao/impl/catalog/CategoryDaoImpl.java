package com.ntreddy.dd.ecommerce.dao.impl.catalog;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntreddy.dd.ecommerce.dao.catalog.CategoryDao;
import com.ntreddy.dd.ecommerce.entity.Category;
import com.ntreddy.dd.ecommerce.entity.Product;
import com.ntreddy.dd.ecommerce.sql.queries.CategoryQuerys;
import com.ntreddy.dd.ecommerce.util.Pagination;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private CategoryQuerys sql;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public Long createCategory(Category category) {
	        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		    System.out.println(sql.getInsert());    
	        int rowsAffected = jdbcTemplate.update(conn -> {
	            // Pre-compiling SQL
	            PreparedStatement preparedStatement = conn.prepareStatement(sql.getInsert(), Statement.RETURN_GENERATED_KEYS);
	            // Set parameters
	            preparedStatement.setString(1, category.getName());
	            preparedStatement.setInt(2, 1);
	            preparedStatement.setObject(3, LocalDateTime.now());
	            return preparedStatement;
	        }, generatedKeyHolder);
	        // Get auto-incremented ID
	        Integer id = generatedKeyHolder.getKey().intValue();
	        System.out.println("rowsAffected = {}, id={}"+rowsAffected+"---"+ id);
	        return (Long) generatedKeyHolder.getKey().longValue();
    }
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Category> findAll(Pagination page) {
		List<Category> allCategory = jdbcTemplate.query(
                sql.getFindAll(),new Object[] {page.getLimit(),page.getOffset()},
                new BeanPropertyRowMapper<Category>(Category.class));
		System.out.println(page.toString());
        return allCategory;
	}
	
//	@SuppressWarnings("deprecation")
//	@Override
//	public <T> List<Category> findAll(Pagination page) {
//		List<T> allCategory = (List<T>) jdbcTemplate.query(
//                sql.getFindAll(),new Object[] {page.getLimit(),page.getOffset()},
//                new BeanPropertyRowMapper<Category>(Category.class));
//		System.out.println(page.toString());
////        return allCategory;
//		int count=100;
//        return new JdbcPage<T>(page.getOffset(),
//       			(int) count/page.getOffset(),
//       			(int) count,
//       			allCategory);
//	}
	
	@SuppressWarnings({ "deprecation" })
	public Category findById(Long id) {
		 return (Category) jdbcTemplate.queryForObject(
				 sql.getFindById(), 
					new Object[]{id}, 
					new BeanPropertyRowMapper<Category>(Category.class));
	    }

	@Override
	public Page<Product> findAllByCategory_Id(Long categoryId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Long id, Category updatedCategory) {
		 return jdbcTemplate.update(sql.getUpdate(),
			        new Object[] { updatedCategory.getName(), updatedCategory.getLevel(),LocalDateTime.now(),id});
	}
	
	 @Override
	  public int deleteById(Long id) {
	    return jdbcTemplate.update(sql.getDeleteById(), id);
	  }


//	@Override
//	public Page<Product> findAllByCategory_Id(Long categoryId, Pageable pageable) {
//		int count=100;
//		List<Product> allCategory = jdbcTemplate.query(
//              sql.getFindAll(),new Object[] {pageable.getPageNumber(),pageable.getOffset()},
//              new BeanPropertyRowMapper<Category>(Category.class));
//		
//		
//		return allCategory;
//	}

//	@Override
//	public Page<Product> findAllByCategory_Id(Long categoryId, Pageable pageable) {
//		
//		String rowCountSql = "SELECT count(1) AS row_count " +
//              "FROM auditing " +
//              "WHERE module = ? ";
//		 int total =
//               jdbcTemplate.queryForObject(
//                       rowCountSql,
//                       new Object[]{categoryId}, (rs, rowNum) -> rs.getInt(1)
//               );
//		
//		 String querySql = "SELECT name, action, operator, operated_at " +
//               "FROM auditing " +
//               "WHERE module = ? " +
//               "LIMIT " + pageable.getPageSize() + " " +
//               "OFFSET " + pageable.getOffset();
//       List<Product> demos = jdbcTemplate.query(
//               querySql,
//               new Object[]{categoryId}, (rs, rowNum) -> Product.builder()
//                       .rowNum(rowNum)
//                       .operatedAt(rs.getTimestamp("operated_at").toLocalDateTime())
//                       .operator(rs.getString("operator"))
//                       .action(rs.getString("action"))
//                       .name(rs.getString("name"))
//                       .build()
//       );

//       return new JdbcPage<T>(arg0,
//   			(int) count/pageSize,
//   			(int) count,
//   			jdbcTemplate.query(qu,this.rowMapper));
////       return new PageImpl<>(demos, pageable, total);
//		
//	}
	
	
	 
	 
//	 String sql = "insert into role(name, code) values(?,?);" +
//			    "insert into person(first_name, last_name, description, role_id) values(?,?,?,(SELECT LAST_INSERT_ID()));";
//
//			int[] arr = template.batchUpdate(sql, new BatchPreparedStatementSetter() {
//
//			    @Override
//			    public void setValues(PreparedStatement ps, int i) throws SQLException {
//			        Role role = roles.get(i);
//			        Person person = list.get(i);
//			        ps.setObject(1, role.getName());
//			        ps.setObject(2, role.getCode();
//			        ps.setObject(3, person.getFirstName());
//			        ps.setObject(4, person.getLastName());
//			        ps.setObject(5, person.getDescription());
//			    }
//
//			    @Override
//			    public int getBatchSize() {
//			        return list.size()
//			    }
//			});

	
//	public Page<Demo> findDemoByPage(Pageable pageable) {
//        String rowCountSql = "SELECT count(1) AS row_count " +
//                "FROM auditing " +
//                "WHERE module = ? ";
//        int total =
//                jdbcTemplate.queryForObject(
//                        rowCountSql,
//                        new Object[]{Module.ADMIN_OPERATOR.getModule()}, (rs, rowNum) -> rs.getInt(1)
//                );
//
//        String querySql = "SELECT name, action, operator, operated_at " +
//                "FROM auditing " +
//                "WHERE module = ? " +
//                "LIMIT " + pageable.getPageSize() + " " +
//                "OFFSET " + pageable.getOffset();
//        List<Demo> demos = jdbcTemplate.query(
//                querySql,
//                new Object[]{Module.ADMIN_OPERATOR.getModule()}, (rs, rowNum) -> Demo.builder()
//                        .rowNum(rowNum)
//                        .operatedAt(rs.getTimestamp("operated_at").toLocalDateTime())
//                        .operator(rs.getString("operator"))
//                        .action(rs.getString("action"))
//                        .name(rs.getString("name"))
//                        .build()
//        );
//
//        return new PageImpl<>(demos, pageable, total);
//    }
}

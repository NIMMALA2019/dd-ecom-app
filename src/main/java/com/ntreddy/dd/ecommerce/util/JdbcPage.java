package com.ntreddy.dd.ecommerce.util;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ntreddy.dd.ecommerce.entity.Product;

public class JdbcPage<T> implements Page<T> {
	Pageable pageable;
	int totalPages;
	int numberOfElements;
	int totalNumbers;
	List<T> content;	
	public JdbcPage(Pagination pageable, int totalPages, 
			int totalNumbers, List<T> content) {
		super();
//		this.pageable = pageable.;
		this.totalPages = totalPages;		
		this.totalNumbers = totalNumbers;
		this.content = content;
	}

//	public JdbcPage(List<T> content, Pageable pageable, long total) {
//		
//		
//		pageable.toOptional().filter(it -> !content.isEmpty())//
//				.filter(it -> it.getOffset() + it.getPageSize() > total)//
//				.map(it -> it.getOffset() + content.size())//
//				.orElse(total);
//		this.pageable = pageable;
//		this.totalPages = (int)total;		
//		this.content = content;
//		
//		
//		
//	}


	

	@Override
	public int getNumber() {
		return pageable.getPageNumber();
	}



	@Override
	public int getSize() {
		return pageable.getPageSize();
	}



	@Override
	public int getNumberOfElements() {
		return this.getContent().size();
	}



	@Override
	public List<T> getContent() {
		return content;
	}



	@Override
	public boolean hasContent() {
		return !content.isEmpty();
	}



	@Override
	public Sort getSort() {
		return this.pageable.getSort();
	}



	@Override
	public boolean isFirst() {
		return pageable.getPageNumber() == 0;
	}



	@Override
	public boolean isLast() {
		return pageable.getPageNumber() == totalPages;
	}



	@Override
	public boolean hasNext() {
		return pageable.getPageNumber() != totalPages;
	}



	@Override
	public boolean hasPrevious() {
		return pageable.getPageNumber() != 0;
	}



	@Override
	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterator<T> iterator() {
		return content.iterator();
	}



	@Override
	public int getTotalPages() {
		return this.totalPages;
	}



	@Override
	public long getTotalElements() {
		return this.totalNumbers;
	}



	@Override
	public <U> Page<U> map(Function<? super T, ? extends U> converter) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

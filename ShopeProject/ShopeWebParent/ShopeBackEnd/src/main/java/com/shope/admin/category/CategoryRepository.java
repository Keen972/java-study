package com.shope.admin.category;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.shope.common.entity.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>{
	
	public Category findByName(String name);
	
	public Category findByAlias(String alias);
	
}

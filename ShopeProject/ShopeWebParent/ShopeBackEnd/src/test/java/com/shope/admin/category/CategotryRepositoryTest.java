package com.shope.admin.category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shope.common.entity.Category;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategotryRepositoryTest {
	
	@Autowired
	private CategoryRepository repo;
	
//	@Autowired
//	private TestEntityManager entityManager;
	
//	@Test
//	public void testCreateRootCategory() {
//		Category addCategory1 = new Category("Computers");
//		Category savedCategory1 = repo.save(addCategory1);
//		Category addCategory2 = new Category("Electronics");
//		Category savedCategory2 = repo.save(addCategory2);
//		
//		assertThat(savedCategory1.getId()).isGreaterThan(0);
//		assertThat(savedCategory2.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void testCreateSubCategory() {
//		Category parent = new Category(1);
//		Category subCategory = new Category("Desktops", parent);
//		Category savedCategory = repo.save(subCategory);
//		
//		assertThat(savedCategory.getId()).isGreaterThan(0);
//	}
	
	@Test
	public void testGetCategory() {
		Category category1 = repo.findById(1).get();
		System.out.println(category1.getName());
		Set<Category> computerChildren = category1.getChildren();
	    computerChildren.forEach(item1 -> System.out.println("--"+item1.getName()));
	    
	    Category category2 = repo.findById(2).get();
		System.out.println(category2.getName());
		Set<Category> electronicChildren = category2.getChildren();
		electronicChildren.forEach(item2 -> System.out.println("--"+item2.getName()));
	    
	}
	
	
//	@Test
//	public void testDepthOfCategory() {
//		Category category1 = repo.findById(1).get();
//		System.out.println(category1.getName());
//		Set<Category> computerChildren = category1.getChildren();
////		computerChildren.forEach(item1 -> System.out.println("--"+item1.getName()));
//		for(Category item : computerChildren) {
//			System.out.println("--"+item.getName());
//			Set<Category> computerGrandChildren = repo.findById(item.getId()).get().getChildren();
//			computerGrandChildren.forEach(grandItem -> System.out.println("-0-0" + grandItem.getName()));
//		}

//		Category category2 = repo.findById(2).get();
//		System.out.println(category2.getName());
//		Set<Category> electronicChildren = category2.getChildren();
////		electronicChildren.forEach(item2 -> System.out.println("--"+item2.getName()));
//		for(Category item : electronicChildren) {
//			System.out.println("--"+item.getName());
//			Set<Category> electronicGrandChildren = repo.findById(item.getId()).get().getChildren();
//			electronicGrandChildren.forEach(grandItem -> System.out.println("-0-0" + grandItem.getName()));
//		}
//	}
	
//	@Test
//	   public void testPrintHierarchicalCategories() {
//	      Iterable<Category> categories = repo.findAll();
//	      
//	      for(Category category : categories) {
//	         if(category.getParent() == null) {
//	            System.out.println(category.getName());
//	            
//	            Set<Category> children = category.getChildren();
//	            
//	            for(Category subCategory : children) {
//	               System.out.println("--" + subCategory.getName());
//	               printChildren(subCategory,1);
//	            }
//	         }
//	      }
//	   }
//	   
//	   private void printChildren(Category parent, int subLevel) {
//	      int newSubLevel = subLevel + 1;
//	      Set<Category> children = parent.getChildren();
//	      
//	      for(Category subCategory : children) {
//	         for(int i=0; i<newSubLevel; i++) {
//	            System.out.print("--");
//	         }
//	         System.out.println(subCategory.getName());
//	         
//	         printChildren(subCategory, newSubLevel);
//	      }
//	      
//	   }
	
	@Test
	public void testFindByName() {
		String name = "Computers";
		Category category = repo.findByName(name);
		assertThat(category).isNotNull();
		assertThat(category.getName()).isEqualTo(name);
	}
	
	@Test
	public void testFindByAlias() {
		String alias = "laptops";
		Category category = repo.findByAlias(alias);
		assertThat(category).isNotNull();
		assertThat(category.getName()).isEqualTo(alias);
	}
	
}

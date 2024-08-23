package com.shope.admin.category;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shope.common.entity.Category;
import com.shope.common.entity.User;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAll(){
		return (List<Category>) repo.findAll();
	}

//	public List<Category> listCategoriesUsedInForm() {
//		List<Category> listParent = new ArrayList<>();
//		Iterable<Category> categories = repo.findAll();
//		for(Category category : categories) {
//	         if(category.getParent() == null) {
//	        	 listParent.add(category);
//	        	 Set<Category> children = category.getChildren();
//	        	 for(Category subCategory : children) {
//	        		 subCategory.setName("--"+subCategory.getName());
//	        		 listParent.add(subCategory);
//	        		 getChildren(listParent, subCategory,1);
//	        		
//	        	 }
//	         }
//		}
//		
//		return listParent;
//	}
//
//	private void getChildren(List<Category> listParent, Category parent, int subLevel) {
//		int newSubLevel = subLevel + 1;
//		Set<Category> children = parent.getChildren();
//		for(Category subCategory : children) {
//			for(int i=0; i<newSubLevel; i++) {
//	            subCategory.setName("--"+subCategory.getName());
//	            listParent.add(subCategory);
//	         }
//			
//			getChildren(listParent, subCategory, newSubLevel);
//			
//		}
//		
//		
//	}
	
	public List<Category> listCategoriesUsedInForm() {
		List<Category> categoriesUsedInForm = new ArrayList<>();
		
		Iterable<Category> categoriesInDB = repo.findAll();
		
		for(Category category : categoriesInDB) {
			if(category.getParent() == null) {
//				categoriesUsedInForm.add(new Category(category.getName()));
				categoriesUsedInForm.add(Category.copyIdAndName(category));

				Set<Category> children = category.getChildren();
				
				for(Category subCategory : children) {
					String name = "--" + subCategory.getName();
//					categoriesUsedInForm.add(new Category(name));
					categoriesUsedInForm.add(Category.copyIdAndName(name, subCategory));
					
					listChildren(categoriesUsedInForm, subCategory, 1);
				}
			}
		}
		return categoriesUsedInForm;
	}

	private void listChildren(List<Category> categoriesUsedInForm, Category parent, int subLevel) {
		int newSubLevel = subLevel + 1;
		Set<Category> children = parent.getChildren();
		for(Category subCategory : children) {
			String name = "";
			for(int i = 0; i<newSubLevel; i++) {
				name += "--";
			}
			name += subCategory.getName();
	//		categoriesUsedInForm.add(new Category(name));
			categoriesUsedInForm.add(Category.copyIdAndName(name, subCategory));
			listChildren(categoriesUsedInForm, subCategory, newSubLevel);
		}
	}
	
	public Category save(Category category) {
		return repo.save(category);
	}
	
	public Category findById(Integer id) throws CategoryNotFoundException {
		try{
			return repo.findById(id).get();
		}catch(NoSuchElementException ex) {
			throw new CategoryNotFoundException("Could not find any category wirh ID "+ id);
		}
		
	}
	
	public String isNameOrAliasUnique(Integer id, String name, String alias) {
		Category categoryByName = repo.findByName(name);
		Category categoryByAlias = repo.findByAlias(alias);
		
		if(categoryByName == null && categoryByAlias == null) return "OK";
		
		boolean isCreatingNew = (id == null || id == 0); //신규생성은 id == null -> true
		
		if(isCreatingNew) {                         //==========신규생성==========
			if(categoryByName != null && categoryByAlias != null) {
				return "DuplicatedBoth";
			}else if(categoryByName != null && categoryByAlias == null) {
				return "DuplicatedName";
			}else if(categoryByName == null && categoryByAlias != null){
				return "DuplicatedAlias";
			}
		}else {                                    //=========기존 카테고리 정보수정========
			if(categoryByName.getId() == id && categoryByAlias.getId() == id) {  
				return "OK";
			}else if(categoryByName.getId() != id && categoryByAlias.getId() == id){
				return "DuplicatedName";
			}else if(categoryByName.getId() == id && categoryByAlias.getId() != id){
				return "DuplicatedAlias";
			}else if(categoryByName.getId() != id && categoryByAlias.getId() != id){
				return "DuplicatedBoth";
			}else return "Error";
		}
		return "OK";
	}
	

	
}

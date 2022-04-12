package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(Category category) throws Exception {
		Category cat = this.categoryRepository.findByTitle(category.getTitle());
		if(cat!=null)
		{
			System.out.println("category already present");
			throw new Exception("category already present");
		}else {
			return this.categoryRepository.save(category);
		}
	}

	@Override
	public Category updateCategory(Category category) throws Exception {
		Category cat = this.categoryRepository.findByCid(category.getCid());
		if(cat==null)
		{
			System.out.println("category not present");
			throw new Exception("category not present");
		}else {
			return this.categoryRepository.save(category);
		}
	}

	@Override
	public Set<Category> getAllCategories() {
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return this.categoryRepository.findByCid(categoryId);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
		
	}

}

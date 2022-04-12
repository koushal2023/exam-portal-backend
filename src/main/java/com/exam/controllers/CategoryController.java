package com.exam.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.exam.Category;
import com.exam.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

// add category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category) throws Exception {
		Category cat = categoryService.addCategory(category);
		return ResponseEntity.ok(cat);
	}

//	update
	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category) throws Exception {
		Category cat = categoryService.updateCategory(category);
		return ResponseEntity.ok(cat);
	}

//	get All Category
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		Set<Category> allCategories = categoryService.getAllCategories();
		return ResponseEntity.ok(allCategories);
	}

//	get category by category id
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategoryByid(@PathVariable("categoryId") Long categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(category);
	}
	
//	delete category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId){
		categoryService.deleteCategory(categoryId);
	}
}

package com.blogapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.CategoryDto;
import com.blogapp.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateDto) {
		CategoryDto categoryDto = this.categoryService.createCategory(cateDto);
		return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
	}

	// Update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto cateDto,
			@PathVariable("categoryId") Integer id) {
		CategoryDto categoryDto = this.categoryService.updateCategory(cateDto, id);
		return new ResponseEntity<>(categoryDto, HttpStatus.OK);
	}

	// Delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		if (this.categoryService.getCategory(catId) != null) {
			this.categoryService.deleteCategory(catId);
			return new ResponseEntity<>(new ApiResponse("Category deleted", true), HttpStatus.OK);

		} else
			return new ResponseEntity<>(new ApiResponse("No category found with the given Id", false),
					HttpStatus.BAD_REQUEST);

	}

	// getSingle

	@GetMapping("/{catId}")
	public ResponseEntity<?> getSingleCategory(@PathVariable("catId") Integer catId) {
		return ResponseEntity.ok(this.categoryService.getCategory(catId));
	}

	// getAll

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getAllCategory());

	}
}

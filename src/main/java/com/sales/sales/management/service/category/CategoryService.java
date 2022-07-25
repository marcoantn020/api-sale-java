package com.sales.sales.management.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sales.sales.management.repository.CategoryRepositoryInterface;

import entity.Category;
import exceptions.BusinessRuleException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepositoryInterface categoryRepositoryInterface;
	
	public List<Category> listAll() {
		return categoryRepositoryInterface.findAll();
	}
	
	public Optional<Category> listOne(Long code) {
		return categoryRepositoryInterface.findById(code);	
	}
	
	public Category register(Category category) {
		validateDuplicateCategory(category);
		return categoryRepositoryInterface.save(category);
	}
	
	public Category update(Long code, Category category) {
		Category categorySave = validateIfTheCategoryExists(code);
		validateDuplicateCategory(category);
		BeanUtils.copyProperties(category, categorySave, "code");
		return categoryRepositoryInterface.save(categorySave);
	}
	
	public void delete(Long code) {
		Category category = validateIfTheCategoryExists(code);
		categoryRepositoryInterface.deleteById(category.getCode());
	}

	private Category validateIfTheCategoryExists(Long code) {
		Optional<Category> category = listOne(code);
		if (category.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return category.get();
	}
	
	private void validateDuplicateCategory(Category category) {
		Category categoryFound = categoryRepositoryInterface.findByName(category.getName());
		if (categoryFound != null && category.getCode() != categoryFound.getCode()) {
			throw new BusinessRuleException(String.format("A categoria [%s] já está cadastrada.", category.getName().toUpperCase()));
		}
	}
}

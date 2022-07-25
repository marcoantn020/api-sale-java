package com.sales.sales.management.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sales.sales.management.repository.CategoryRepositoryInterface;
import com.sales.sales.management.repository.ProductRepositoryInterface;
import com.sales.sales.management.service.category.CategoryService;

import entity.Product;
import exceptions.BusinessRuleException;

@Service
public class ProductService {

	@Autowired
	private ProductRepositoryInterface productRepositoryInterface;
	
	@Autowired
	private CategoryService categoryService;
	
	public List<Product> listAll(Long codeCategory) {
		validateIfTheProductCategoryExists(codeCategory);
		return productRepositoryInterface.findByCategoryCode(codeCategory);
	}
	
	public Optional<Product> searchByCode(Long codeCategory, Long codeProduct) {
		validateIfTheProductCategoryExists(codeCategory);
		return productRepositoryInterface.findByCategoryCodeAndCode(codeCategory, codeProduct);	
	}
	
	public Product register(Long codeCategory,Product product) {
		validateIfTheProductCategoryExists(codeCategory);
		validateDuplicateProduct(product);
		return productRepositoryInterface.save(product);
	}
	
	public Product update(Long codeCategory, Long codeProduct, Product product) {
		validateIfTheProductCategoryExists(codeCategory);
		Product productUpdate = validateIfTheProductExist(codeProduct, codeCategory);
		validateDuplicateProduct(product);
		BeanUtils.copyProperties(product, productUpdate, "code");
		return productRepositoryInterface.save(productUpdate);
	}
	
	public void delete(long codeCategory, Long codeProduct) {
		validateIfTheProductCategoryExists(codeCategory);
		Product productDelete = validateIfTheProductExist(codeProduct, codeCategory);
		productRepositoryInterface.delete(productDelete);
	}
	
	public void updateQuantityInStock(Product product) {
		productRepositoryInterface.save(product);
	}
	
	public Product validateIfTheProductExist(Long codeProduct) {
		Optional<Product> product = productRepositoryInterface.findById(codeProduct);
		if(product.isEmpty()) {
			throw new BusinessRuleException(String.format("O produto de codigo [%s] não foi encontrado", codeProduct));
		}
		return product.get();
	}
	
	private Product validateIfTheProductExist(Long codeProduct, Long codeCategory) {
		Optional<Product> product = searchByCode(codeCategory, codeProduct);
		if(product.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return product.get();
	}
	
	private void validateIfTheProductCategoryExists(Long codeCategory) {
		if (codeCategory == null) {
			throw new BusinessRuleException("A categoria não pode ser nula");
		}
		
		if (categoryService.listOne(codeCategory).isEmpty()) {
			throw new BusinessRuleException(String.format("Categoria de codigo [%s] informada não existe no cadastro", codeCategory));
		}
	}
	
	private void validateDuplicateProduct(Product product) {
		Optional<Product> productExist = productRepositoryInterface.findByCategoryCodeAndDescription(product.getCategory().getCode(), product.getDescription());
		if (productExist.isPresent() && productExist.get().getCode() != product.getCode()) {
			throw new BusinessRuleException(String.format("O Produto[%s] já está cadastro", product.getDescription()));
		}
	}
}









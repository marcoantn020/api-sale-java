package com.sales.sales.management.controller.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sales.sales.management.service.category.CategoryService;

import dto.categoryDTO.CategoryRequestDTO;
import dto.categoryDTO.CategoryResponseDTO;
import entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Categoria")
@RestController
@RequestMapping("/categoria")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@ApiOperation(value = "Listar", nickname = "listAllCategory")
	@GetMapping
	public List<CategoryResponseDTO> listAll() {
		return categoryService.listAll().stream()
				.map(categoryData -> CategoryResponseDTO.convertToCategoryDTO(categoryData)).collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar por codigo", nickname = "listOneCategory")
	@GetMapping("/{code}")
	public ResponseEntity<CategoryResponseDTO> listOne(@PathVariable Long code) {
		Optional<Category> category = categoryService.listOne(code);
		return category.isPresent() ? ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(category.get())) : ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Registar", nickname = "registerCategory")
	@PostMapping
	public ResponseEntity<CategoryResponseDTO> register(@Valid @RequestBody CategoryRequestDTO categoryDto) {
		Category categorySave = categoryService.register(categoryDto.covertToEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponseDTO.convertToCategoryDTO(categorySave));
	}

	@ApiOperation(value = "Atualizar", nickname = "updateCategory")
	@PutMapping("/{code}")
	public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long code, @Valid @RequestBody CategoryRequestDTO categorydto) {
		Category categoryUpdate = categoryService.update(code, categorydto.covertToEntity(code));
		return ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(categoryUpdate));
	}

	@ApiOperation(value = "Deletar", nickname = "deleteCategory")
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long code) {
		categoryService.delete(code);
	}
}

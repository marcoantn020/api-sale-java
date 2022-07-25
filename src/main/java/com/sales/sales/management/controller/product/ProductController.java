package com.sales.sales.management.controller.product;

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

import com.sales.sales.management.service.product.ProductService;

import dto.productDTO.ProductRequestDTO;
import dto.productDTO.ProductResponseDTO;
import entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produto")
@RestController
@RequestMapping("/categoria/{codeCategory}/produto")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "Listar", nickname = "listAllProduct")
	@GetMapping
	public List<ProductResponseDTO> listAll(@PathVariable Long codeCategory) {
		return productService.listAll(codeCategory).stream()
				.map(product -> ProductResponseDTO.convertToProductDTO(product)).collect(Collectors.toList());
	}

	@ApiOperation(value = "Buscar por codigo", nickname = "searchByCodeProduct")
	@GetMapping("/{codeProduct}")
	public ResponseEntity<ProductResponseDTO> searchByCode(@PathVariable Long codeCategory,
			@PathVariable Long codeProduct) {
		Optional<Product> product = productService.searchByCode(codeCategory, codeProduct);
		return product.isPresent() ? ResponseEntity.ok(ProductResponseDTO.convertToProductDTO(product.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "registerProduct")
	@PostMapping
	public ResponseEntity<ProductResponseDTO> register(@PathVariable Long codeCategory,
			@Valid @RequestBody ProductRequestDTO product) {
		Product productSave = productService.register(codeCategory, product.convertToProductEntity(codeCategory));
		return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponseDTO.convertToProductDTO(productSave));
	}

	@ApiOperation(value = "Atualizar", nickname = "updateProduct")
	@PutMapping("/{codeProduct}")
	public ResponseEntity<ProductResponseDTO> update(@PathVariable Long codeCategory, @PathVariable Long codeProduct,
			@Valid @RequestBody ProductRequestDTO product) {
		Product productUpdate = productService.update(codeCategory, codeProduct,
				product.convertToProductEntity(codeCategory, codeProduct));
		return ResponseEntity.ok(ProductResponseDTO.convertToProductDTO(productUpdate));
	}

	@ApiOperation(value = "Deletar", nickname = "deleteProduct")
	@DeleteMapping("/{codeProduct}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codeCategory, Long codeProduct) {
		productService.delete(codeCategory, codeProduct);
	}
}

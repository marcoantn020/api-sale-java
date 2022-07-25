package com.sales.sales.management.controller.sale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sales.sales.management.service.sale.SaleService;

import dto.saleDTO.ClientSaleResponseDTO;
import dto.saleDTO.SaleRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Venda")
@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@ApiOperation(value = "Buscar venda por codigo do cliente", nickname = "listSaleByClientSale")
	@GetMapping("/cliente/{codeClient}")
	public ResponseEntity<ClientSaleResponseDTO> listSaleByClient(@PathVariable Long codeClient) {
		return ResponseEntity.ok(saleService.listSaleByClient(codeClient));
	}
	
	@ApiOperation(value = "Buscar venda por codigo", nickname = "searchSaleByCodeSale")
	@GetMapping("/{codeSale}")
	public ResponseEntity<ClientSaleResponseDTO> searchSaleByCode(@PathVariable Long codeSale) {
		return ResponseEntity.ok(saleService.searchSaleByCode(codeSale));
	}
	
	@ApiOperation(value = "Salvar", nickname = "registerSale")
	@PostMapping("/{codeClient}")
	public ResponseEntity<ClientSaleResponseDTO> searchSaleByCode(@PathVariable Long codeClient,@Valid @RequestBody SaleRequestDTO saleDto) {
		ClientSaleResponseDTO sale = saleService.register(codeClient, saleDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(sale);
	}
	
	@ApiOperation(value = "deletar venda pelo codigo da venda", nickname = "deleteSale")
	@DeleteMapping("/{codeSale}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codeSale) {
		saleService.delete(codeSale);
	}
}

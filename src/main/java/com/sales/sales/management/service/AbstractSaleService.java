package com.sales.sales.management.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dto.itemSaleDTO.ItemSaleResponseDTO;
import dto.saleDTO.ClientSaleResponseDTO;
import dto.saleDTO.ItemSaleRequestDTO;
import dto.saleDTO.SaleResponseDTO;
import entity.ItemSale;
import entity.Product;
import entity.Sale;

public abstract class AbstractSaleService {
	
	protected ClientSaleResponseDTO returningClientResponseDTO(Sale sale, List<ItemSale> itemSale) {
		return new ClientSaleResponseDTO(sale.getClient().getName(), Arrays.asList(
				createSaleResponseDTO(sale, itemSale)));
	}
	
	protected ItemSale createItemSale(ItemSaleRequestDTO itemSaleDto, Sale sale) {
		return new ItemSale(itemSaleDto.getQuantity(), itemSaleDto.getPriceSold(),
				new Product(itemSaleDto.getCodeProduct()), sale);
	}
	
	protected SaleResponseDTO createSaleResponseDTO(Sale sale, List<ItemSale> itensSaleList) {
		List<ItemSaleResponseDTO> itemSale = itensSaleList.stream()
				.map(this::createItemSaleResponseDTO).collect(Collectors.toList());
		return new SaleResponseDTO(sale.getCode(), sale.getDate(), itemSale);
	}

	protected ItemSaleResponseDTO createItemSaleResponseDTO(ItemSale itemSale) {
		return new ItemSaleResponseDTO(itemSale.getCode(), itemSale.getQuantity(), itemSale.getPriceSold(),
				itemSale.getProduct().getCode(), itemSale.getProduct().getDescription());
	}
}

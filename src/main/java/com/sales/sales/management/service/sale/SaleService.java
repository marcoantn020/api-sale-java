package com.sales.sales.management.service.sale;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.sales.management.repository.ItemSaleRespositoryInterface;
import com.sales.sales.management.repository.SaleRepositoryInterface;
import com.sales.sales.management.service.AbstractSaleService;
import com.sales.sales.management.service.client.ClientService;
import com.sales.sales.management.service.product.ProductService;

import dto.saleDTO.ClientSaleResponseDTO;
import dto.saleDTO.ItemSaleRequestDTO;
import dto.saleDTO.SaleRequestDTO;
import dto.saleDTO.SaleResponseDTO;
import entity.Client;
import entity.ItemSale;
import entity.Product;
import entity.Sale;
import exceptions.BusinessRuleException;

@Service
public class SaleService extends AbstractSaleService {

	private ClientService clientService;
	private SaleRepositoryInterface saleRepositoryInterface;
	private ItemSaleRespositoryInterface itemSaleRespositoryInterface;
	private ProductService productService;

	@Autowired
	public SaleService(ClientService clientService, SaleRepositoryInterface saleRepositoryInterface,
			ItemSaleRespositoryInterface itemSaleRespositoryInterface, ProductService productService) {
		this.clientService = clientService;
		this.saleRepositoryInterface = saleRepositoryInterface;
		this.itemSaleRespositoryInterface = itemSaleRespositoryInterface;
		this.productService = productService;
	}

	public ClientSaleResponseDTO listSaleByClient(Long codeClient) {
		Client client = validateIfTheSaleCustomerExists(codeClient);
		List<SaleResponseDTO> saleResponse = saleRepositoryInterface.findByClientCode(codeClient).stream()
				.map(sale -> createSaleResponseDTO(sale, itemSaleRespositoryInterface.findBySaleByCode(sale.getCode())))
				.collect(Collectors.toList());
		return new ClientSaleResponseDTO(client.getName(), saleResponse);
	}

	public ClientSaleResponseDTO searchSaleByCode(Long codeSale) {
		Sale sale = validateIfTheSaleExists(codeSale);
		List<ItemSale> itensSaleList = itemSaleRespositoryInterface.findBySaleByCode(sale.getCode());
		return returningClientResponseDTO(sale, itensSaleList);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ClientSaleResponseDTO register(Long codeClient, SaleRequestDTO saleDto) {
		Client client = validateIfTheSaleCustomerExists(codeClient);
		validateIfTheProductExists(saleDto.getItensSaleDto());
		Sale saveSale = saveSale(client, saleDto);
		return returningClientResponseDTO(saveSale, itemSaleRespositoryInterface.findBySaleByCode(saveSale.getCode()));
	}

	private Sale saveSale(Client client, SaleRequestDTO saleDto) {
		Sale saleSave = saleRepositoryInterface.save(new Sale(saleDto.getDate(), client));
		saleDto.getItensSaleDto().stream().map(itemSaleDto -> createItemSale(itemSaleDto, saleSave))
				.forEach(itemSaleRespositoryInterface::save);
		return saleSave;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void delete(Long codeSale) {
		validateIfTheSaleExists(codeSale);
		List<ItemSale> itensSale = itemSaleRespositoryInterface.findBySaleByCode(codeSale);
		validateIfTheProductExistsAndReturnToStock(itensSale);
		itemSaleRespositoryInterface.deleteAll(itensSale);
		saleRepositoryInterface.deleteById(codeSale);
	}
	
	private void validateIfTheProductExistsAndReturnToStock(List<ItemSale> itensSale) {
		itensSale.forEach(item -> {
			Product product = productService.validateIfTheProductExist(item.getProduct().getCode());
			product.setQuantity(product.getQuantity() + item.getQuantity());
			productService.updateQuantityInStock(product);
		});
	}

	private void validateIfTheProductExists(List<ItemSaleRequestDTO> itensSaleDto) {
		itensSaleDto.forEach(item -> {
			Product product = productService.validateIfTheProductExist(item.getCodeProduct());
			validateQuantityOfProductExists(product, item.getQuantity());
			product.setQuantity(product.getQuantity() - item.getQuantity());
			productService.updateQuantityInStock(product);
		});
	}
	
	private void validateQuantityOfProductExists(Product product, Integer quantitySaleDto) {
		if(!(product.getQuantity() >= quantitySaleDto)) {
			throw new BusinessRuleException(String.format("O produto [%s] não tem essa quantidade [%s] disponivel no estoque", product.getDescription(),quantitySaleDto));
		}
	}

	private Sale validateIfTheSaleExists(Long codeSale) {
		Optional<Sale> sale = saleRepositoryInterface.findById(codeSale);
		if (sale.isEmpty()) {
			throw new BusinessRuleException(String.format("O codigo [%s] da venda não foi encontrado.", codeSale));
		}
		return sale.get();

	}

	private Client validateIfTheSaleCustomerExists(Long codeClient) {
		Optional<Client> client = clientService.searchByCode(codeClient);
		if (client.isEmpty()) {
			throw new BusinessRuleException(String.format("O codigo do cliente [%s] não foi encontrado.", codeClient));
		}
		return client.get();
	}

}

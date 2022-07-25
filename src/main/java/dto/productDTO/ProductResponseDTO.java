package dto.productDTO;

import java.math.BigDecimal;

import dto.categoryDTO.CategoryResponseDTO;
import entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Product response DTO")
public class ProductResponseDTO {

	@ApiModelProperty(value = "Code")
	private Long code;

	@ApiModelProperty(value = "description")
	private String description;

	@ApiModelProperty(value = "Quantity")
	private Integer quantity;

	@ApiModelProperty(value = "Price cost")
	private BigDecimal priceCost;

	@ApiModelProperty(value = "Sale price")
	private BigDecimal salePrice;

	@ApiModelProperty(value = "Observation")
	private String observation;

	@ApiModelProperty(value = "Category")
	private CategoryResponseDTO category;

	public ProductResponseDTO(Long code, String description, Integer quantity, BigDecimal priceCost,
			BigDecimal salePrice, String observation, CategoryResponseDTO category) {
		this.code = code;
		this.description = description;
		this.quantity = quantity;
		this.priceCost = priceCost;
		this.salePrice = salePrice;
		this.observation = observation;
		this.category = category;
	}

	public static ProductResponseDTO convertToProductDTO(Product product) {
		return new ProductResponseDTO(product.getCode(), product.getDescription(), product.getQuantity(),
				product.getPriceCost(), product.getSalePrice(), product.getObservation(),
				CategoryResponseDTO.convertToCategoryDTO(product.getCategory()));
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceCost() {
		return priceCost;
	}

	public void setPriceCost(BigDecimal priceCost) {
		this.priceCost = priceCost;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public CategoryResponseDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryResponseDTO category) {
		this.category = category;
	}

}

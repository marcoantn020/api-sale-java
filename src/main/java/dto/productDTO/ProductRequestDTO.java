package dto.productDTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import entity.Category;
import entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Product request DTO")
public class ProductRequestDTO {

	@ApiModelProperty(value = "Description")
	@NotBlank(message = "descrição")
	@Length(min = 3, max = 100, message = "descrição")
	private String description;

	@ApiModelProperty(value = "Quantity")
	@NotNull(message = "Quantidade")
	private Integer quantity;

	@ApiModelProperty(value = "Price cost")
	@NotNull(message = "preço custo")
	private BigDecimal priceCost;

	@ApiModelProperty(value = "Sale price")
	@NotNull(message = "preço venda")
	private BigDecimal salePrice;

	@ApiModelProperty(value = "observation")
	@Length(max = 500, message = "obervação")
	private String observation;

	public Product convertToProductEntity(Long codeCategory) {
		return new Product(description, quantity, priceCost, salePrice, observation, new Category(codeCategory));
	}

	public Product convertToProductEntity(Long codeCategory, Long codeProduct) {
		return new Product(codeProduct, description, quantity, priceCost, salePrice, observation,
				new Category(codeCategory));
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

}

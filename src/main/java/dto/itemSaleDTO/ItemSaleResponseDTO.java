package dto.itemSaleDTO;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Item Sale response DTO")
public class ItemSaleResponseDTO {

	@ApiModelProperty(value = "Code")
	private Long code;

	@ApiModelProperty(value = "Quantity")
	private Integer quantity;

	@ApiModelProperty(value = "price_sold")
	private BigDecimal priceSold;

	@ApiModelProperty(value = "Code_product")
	private Long codeProduct;

	@ApiModelProperty(value = "description_product")
	private String DescriptionProduct;

	public ItemSaleResponseDTO(Long code, Integer quantity, BigDecimal priceSold, Long codeProduct,
			String descriptionProduct) {
		this.code = code;
		this.quantity = quantity;
		this.priceSold = priceSold;
		this.codeProduct = codeProduct;
		DescriptionProduct = descriptionProduct;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceSold() {
		return priceSold;
	}

	public void setPriceSold(BigDecimal priceSold) {
		this.priceSold = priceSold;
	}

	public Long getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(Long codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getDescriptionProduct() {
		return DescriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		DescriptionProduct = descriptionProduct;
	}

}

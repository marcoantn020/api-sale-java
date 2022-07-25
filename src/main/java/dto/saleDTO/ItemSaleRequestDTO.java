package dto.saleDTO;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens sale request DTO")
public class ItemSaleRequestDTO {

	@ApiModelProperty(value = "code product")
	@NotNull(message = "codeProduct")
	private Long codeProduct;

	@ApiModelProperty(value = "quantity")
	@NotNull(message = "quantity")
	@Min(value = 1, message = "quantity")
	private Integer quantity;

	@ApiModelProperty(value = "price sold")
	@NotNull(message = "priceSold")
	private BigDecimal priceSold;

	public Long getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(Long codeProduct) {
		this.codeProduct = codeProduct;
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

}

package dto.saleDTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Sale request DTO")
public class SaleRequestDTO {

	@ApiModelProperty(value = "date")
	@NotNull(message = "date")
	private LocalDate date;

	@ApiModelProperty(value = "itens sale")
	@NotNull(message = "itensSaleDto")
	@Valid
	private List<ItemSaleRequestDTO> itensSaleDto;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<ItemSaleRequestDTO> getItensSaleDto() {
		return itensSaleDto;
	}

	public void setItensSaleDto(List<ItemSaleRequestDTO> itensSaleDto) {
		this.itensSaleDto = itensSaleDto;
	}

}

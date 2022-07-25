package dto.saleDTO;

import java.time.LocalDate;
import java.util.List;

import dto.itemSaleDTO.ItemSaleResponseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Sale response DTO")
public class SaleResponseDTO {

	@ApiModelProperty(value = "Code")
	private Long code;

	@ApiModelProperty(value = "Date")
	private LocalDate date;

	@ApiModelProperty(value = "itemSaleResponseDTO")
	private List<ItemSaleResponseDTO> itemSaleResponseDTO;

	public SaleResponseDTO(Long code, LocalDate date, List<ItemSaleResponseDTO> itemSaleResponseDTO) {
		this.code = code;
		this.date = date;
		this.itemSaleResponseDTO = itemSaleResponseDTO;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<ItemSaleResponseDTO> getItemSaleResponseDTO() {
		return itemSaleResponseDTO;
	}

	public void setItemSaleResponseDTO(List<ItemSaleResponseDTO> itemSaleResponseDTO) {
		this.itemSaleResponseDTO = itemSaleResponseDTO;
	}

}

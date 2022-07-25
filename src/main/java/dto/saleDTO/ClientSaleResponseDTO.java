package dto.saleDTO;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Client Sale response DTO")
public class ClientSaleResponseDTO {

	@ApiModelProperty(value = "Name")
	private String name;
	
	@ApiModelProperty(value = "saleResponseDTO")
	private List<SaleResponseDTO> saleResponseDTO;

	public ClientSaleResponseDTO(String name, List<SaleResponseDTO> saleResponseDTO) {
		this.name = name;
		this.saleResponseDTO = saleResponseDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SaleResponseDTO> getSaleResponseDTO() {
		return saleResponseDTO;
	}

	public void setSaleResponseDTO(List<SaleResponseDTO> saleResponseDTO) {
		this.saleResponseDTO = saleResponseDTO;
	}
	
	
}

package dto.clientDTO;

import entity.Client;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Client response DTO")
public class ClientResponseDTO {

	@ApiModelProperty(value = "Code")
	private Long code;

	@ApiModelProperty(value = "Name")
	private String name;

	@ApiModelProperty(value = "Phone")
	private String phone;

	@ApiModelProperty(value = "Active")
	private Boolean active;

	@ApiModelProperty(value = "Address")
	private AddressResponseDTO address;

	public ClientResponseDTO(Long code, String name, String phone, Boolean active, AddressResponseDTO address) {
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.active = active;
		this.address = address;
	}

	public static ClientResponseDTO convertToClientDTO(Client client) {
		AddressResponseDTO addressResponseDTO = new AddressResponseDTO(client.getAddress().getAddress(),
				client.getAddress().getNumber(), client.getAddress().getComplement(), client.getAddress().getDistrict(),
				client.getAddress().getZipcode(), client.getAddress().getCity(), client.getAddress().getState());
		return new ClientResponseDTO(client.getCode(), client.getName(), client.getPhone(), client.getActive(),
				addressResponseDTO);
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public AddressResponseDTO getAddress() {
		return address;
	}

	public void setAddress(AddressResponseDTO address) {
		this.address = address;
	}

}

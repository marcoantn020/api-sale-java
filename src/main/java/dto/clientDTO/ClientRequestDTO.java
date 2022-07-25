package dto.clientDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import entity.Address;
import entity.Client;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Client request DTO")
public class ClientRequestDTO {

	@ApiModelProperty(value = "Name")
	@NotBlank(message = "name")
	@Length(min = 3, max = 50, message = "name")
	private String name;

	@ApiModelProperty(value = "Phone")
	@NotBlank(message = "phone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "phone")
	private String phone;

	@ApiModelProperty(value = "Active")
	@NotNull(message = "active")
	private Boolean active;

	@ApiModelProperty(value = "Address")
	@NotNull(message = "address")
	@Valid
	private AddressRequestDTO addressDto;

	public Client covertToClientEntity() {
		Address address = new Address(addressDto.getAddress(), addressDto.getNumber(), addressDto.getComplement(),
				addressDto.getDistrict(), addressDto.getZipcode(), addressDto.getCity(), addressDto.getState());
		return new Client(name, phone, active, address);
	}

	public Client covertToClientEntity(Long code) {
		Address address = new Address(addressDto.getAddress(), addressDto.getNumber(), addressDto.getComplement(),
				addressDto.getDistrict(), addressDto.getZipcode(), addressDto.getCity(), addressDto.getState());
		return new Client(code, name, phone, active, address);
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

	public AddressRequestDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressRequestDTO addressDto) {
		this.addressDto = addressDto;
	}

}

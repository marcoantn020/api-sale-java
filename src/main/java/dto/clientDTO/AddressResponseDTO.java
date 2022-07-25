package dto.clientDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Address response DTO")
public class AddressResponseDTO {

	@ApiModelProperty(value = "Adrress")
	private String address;

	@ApiModelProperty(value = "Number")
	private Integer number;

	@ApiModelProperty(value = "Complement")
	private String complement;

	@ApiModelProperty(value = "District")
	private String district;

	@ApiModelProperty(value = "Zipcode")
	private String zipcode;

	@ApiModelProperty(value = "City")
	private String city;

	@ApiModelProperty(value = "State")
	private String state;

	public AddressResponseDTO(String address, Integer number, String complement, String district, String zipcode,
			String city, String state) {
		this.address = address;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

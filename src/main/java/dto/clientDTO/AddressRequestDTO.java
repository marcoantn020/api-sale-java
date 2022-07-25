package dto.clientDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Address request DTO")
public class AddressRequestDTO {

	@ApiModelProperty(value = "Adrress")
	@NotBlank(message = "address")
	@Length(min = 3, max = 50, message = "address")
	private String address;

	@ApiModelProperty(value = "Number")
	@NotNull(message = "number")
	private Integer number;

	@ApiModelProperty(value = "Complement")
	@Length(max = 50, message = "complement")
	private String complement;

	@ApiModelProperty(value = "District")
	@NotBlank(message = "district")
	@Length(min = 3, max = 50, message = "district")
	private String district;

	@ApiModelProperty(value = "Zipcode")
	@Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "zipcode")
	private String zipcode;

	@ApiModelProperty(value = "City")
	@NotBlank(message = "city")
	@Length(min = 3, max = 50, message = "city")
	private String city;

	@ApiModelProperty(value = "State")
	@NotBlank(message = "state")
	@Length(min = 3, max = 50, message = "state")
	private String state;

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

package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "address")
	private String address;

	@Column(name = "number")
	private Integer number;

	@Column(name = "complement")
	private String complement;

	@Column(name = "district")
	private String district;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	public Address() {
	}

	public Address(String address, Integer number, String complement, String district, String zipcode, String city,
			String state) {
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

	@Override
	public int hashCode() {
		return Objects.hash(address, city, complement, district, number, state, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(complement, other.complement) && Objects.equals(district, other.district)
				&& Objects.equals(number, other.number) && Objects.equals(state, other.state)
				&& Objects.equals(zipcode, other.zipcode);
	}

}

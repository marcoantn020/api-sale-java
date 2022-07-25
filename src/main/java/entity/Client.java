package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "active")
	private Boolean active;

	@Embedded
	private Address address;

	public Client() {
	}

	public Client(Long code, String name, String phone, Boolean active, Address address) {
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.active = active;
		this.address = address;
	}

	public Client(String name, String phone, Boolean active, Address address) {
		this.name = name;
		this.phone = phone;
		this.active = active;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, address, code, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(active, other.active) && Objects.equals(address, other.address)
				&& Objects.equals(code, other.code) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

}

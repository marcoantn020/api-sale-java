package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "name")
	private String name;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(Long code, String name) {
		this.code = code;
		this.name = name;
	}

	public Category(Long code) {
		this.code = code;
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

	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		return Objects.equals(code, other.code) && Objects.equals(name, other.name);
	}

}

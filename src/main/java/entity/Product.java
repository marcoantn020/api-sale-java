package entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price_cost")
	private BigDecimal priceCost;

	@Column(name = "sale_price")
	private BigDecimal salePrice;

	@Column(name = "observation")
	private String observation;

	@ManyToOne
	@JoinColumn(name = "code_category", referencedColumnName = "code")
	private Category category;

	public Product() {
	}

	public Product(Long code) {
		this.code = code;
	}

	public Product(Long code, String description, Integer quantity, BigDecimal priceCost, BigDecimal salePrice,
			String observation, Category category) {
		this.code = code;
		this.description = description;
		this.quantity = quantity;
		this.priceCost = priceCost;
		this.salePrice = salePrice;
		this.observation = observation;
		this.category = category;
	}

	public Product(String description, Integer quantity, BigDecimal priceCost, BigDecimal salePrice, String observation,
			Category category) {
		this.description = description;
		this.quantity = quantity;
		this.priceCost = priceCost;
		this.salePrice = salePrice;
		this.observation = observation;
		this.category = category;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceCost() {
		return priceCost;
	}

	public void setPriceCost(BigDecimal priceCost) {
		this.priceCost = priceCost;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, code, description, observation, priceCost, quantity, salePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(code, other.code)
				&& Objects.equals(description, other.description) && Objects.equals(observation, other.observation)
				&& Objects.equals(priceCost, other.priceCost) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(salePrice, other.salePrice);
	}

}

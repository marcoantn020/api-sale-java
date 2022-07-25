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
@Table(name = "item_sale")
public class ItemSale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price_sold")
	private BigDecimal priceSold;

	@ManyToOne
	@JoinColumn(name = "code_product", referencedColumnName = "code")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "code_sale", referencedColumnName = "code")
	private Sale sale;

	public ItemSale() {
	}

	public ItemSale(Long code, Integer quantity, BigDecimal priceSold, Product product, Sale sale) {
		this.code = code;
		this.quantity = quantity;
		this.priceSold = priceSold;
		this.product = product;
		this.sale = sale;
	}

	public ItemSale(Integer quantity, BigDecimal priceSold, Product product, Sale sale) {
		super();
		this.quantity = quantity;
		this.priceSold = priceSold;
		this.product = product;
		this.sale = sale;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceSold() {
		return priceSold;
	}

	public void setPriceSold(BigDecimal priceSold) {
		this.priceSold = priceSold;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemSale)) {
			return false;
		}
		ItemSale other = (ItemSale) obj;
		return Objects.equals(code, other.code) && Objects.equals(priceSold, other.priceSold)
				&& Objects.equals(product, other.product) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(sale, other.sale);
	}

}

package entity;

import java.time.LocalDate;
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
@Table(name = "sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "data")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "code_client", referencedColumnName = "code")
	private Client client;

	public Sale() {
	}

	public Sale(LocalDate date, Client client) {
		this.date = date;
		this.client = client;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, code, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sale)) {
			return false;
		}
		Sale other = (Sale) obj;
		return Objects.equals(client, other.client) && Objects.equals(code, other.code)
				&& Objects.equals(date, other.date);
	}

}

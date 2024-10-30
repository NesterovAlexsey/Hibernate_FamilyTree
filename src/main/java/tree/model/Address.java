package tree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "countryId", nullable = false)
	private Country country;
	
	@Column
	private String city;
	
	@Column
	private String homeNumber;
	
	@Column
	private Integer postCode;
	
	@Column
	private Date addressFrom;
	
	@Column
	private Date addressTo;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public Date getAddressFrom() {
		return addressFrom;
	}

	public void setAddressFrom(Date addressFrom) {
		this.addressFrom = addressFrom;
	}

	public Date getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(Date addressTo) {
		this.addressTo = addressTo;
	}

	public Long getId() {
		return id;
	}
		
}

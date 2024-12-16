package tree.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "country" )
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	

	@Column(nullable = false, length = 100, unique = true, name = "country_name")
	private String countryName;
	
	@OneToMany(mappedBy = "country")
    private List<Address> addresses = new ArrayList<>();
	
	//Empty constructor for Hibernet
	public Country() 
	{
		
	}
	
	
	public Country(@NotNull String aCountryName)
	{
		Objects.requireNonNull(aCountryName, "aCountryName");
		
		this.countryName = aCountryName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresses, countryName, id);
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", addresses=" + addresses + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(addresses, other.addresses) && Objects.equals(countryName, other.countryName)
				&& Objects.equals(id, other.id);
	}
	
}

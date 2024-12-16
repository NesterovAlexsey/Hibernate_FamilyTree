package tree.model;

import java.util.Date;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "family_name")
	private String familyName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "Birthday")
	private Date dateOfBirth;
	
	@Column(name = "Day_of_Death")
	private Date dateOfDeath;
	
	@Column
	private String profession;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn( name = "country_id" )
	private Country country;

	@OneToMany( mappedBy="parent", cascade = CascadeType.ALL)
	private List <Person> children;
	
	@ManyToOne
	@JoinColumn( name = "parent_id" )
	private Person parent;
	
	//We should add Address, as ManyToOne, and also from-antill

	//Empty constructor
	public Person()
	{
		
	}
	
	/**
	 * Create object Person
	 * @param aName
	 * @param aFamilieName
	 */
	public Person(String aName, String aFamilieName)
	{
		this.firstName = aName;
		this.familyName = aFamilieName;
	}
	
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first) {
		this.firstName = first;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(children, dateOfBirth, dateOfDeath, description, familyName, id, firstName, middleName,
				parent, profession);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(children, other.children) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(dateOfDeath, other.dateOfDeath) && Objects.equals(description, other.description)
				&& Objects.equals(familyName, other.familyName) && Objects.equals(id, other.id)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(parent, other.parent) && Objects.equals(profession, other.profession);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", familyName=" + familyName + ", lastName=" + firstName + ", middleName="
				+ middleName + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", profession="
				+ profession + ", description=" + description + ", children=" + children + ", parent=" + parent + ", country=" + this.getCountry() +"]";
	}
	
}

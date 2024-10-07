package tree.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "last_name")
	private String lastName;
	
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
	
	@OneToMany( mappedBy="parent", cascade = CascadeType.ALL)
	private List <Person> children;
	
	
}

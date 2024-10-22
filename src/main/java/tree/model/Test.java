package tree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "test_info")
	private String testInfo;
	
	public Long getId() {
		return this.id;
	}
	
	public String getTestInfo() {
		return this.testInfo; 
	}
	
	public void setTestInfo(String aTestInfo) {
		this.testInfo = aTestInfo;
	}
}

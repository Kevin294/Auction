package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testing", schema = "public")
public class TestEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="testing")
	private String testing;
	
	@Column(name="tester")
	private String tester;
	
	public TestEntity() {
		
	}

	public String getTesting() {
		return testing;
	}

	public void setTesting(String testing) {
		this.testing = testing;
	}

	public String getTester() {
		return tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}
	
}

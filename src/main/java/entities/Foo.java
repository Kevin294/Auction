package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="foo", schema="public")
public class Foo implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer key;
	
	@Column (name="foop")
	private String foop;

	public Foo() {
		
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getFoop() {
		return foop;
	}

	public void setFoop(String foop) {
		this.foop = foop;
	}
	
	
}

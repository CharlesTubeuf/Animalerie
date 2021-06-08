package Entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Animal implements Serializable{
	
	@Column(name="CHIP_ID")
	private String chipId;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}


	public Cat(String chipId) {
		super();
		this.chipId = chipId;
	}



	@Override
	public String toString() {
		return "Cat [chipId=" + chipId + ", toString()=" + super.toString() + "]";
	}



	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	
	
	
}

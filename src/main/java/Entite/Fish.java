package Entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Fish")
public class Fish extends Animal implements Serializable{
	
	@Enumerated
	@Column(name="Env")
	private FishLivEnv env;
	
	public Fish() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Fish(FishLivEnv env) {
		super();
		this.env = env;
	}







	@Override
	public String toString() {
		return "Fish [env=" + env + ", toString()=" + super.toString() + "]";
	}



	public FishLivEnv getEnv() {
		return env;
	}

	public void setEnv(FishLivEnv env) {
		this.env = env;
	}
	
	

}

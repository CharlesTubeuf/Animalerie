package Entite;

import javax.persistence.*;

@Embeddable
public class Adresse {
	
	@Column(name = "NUMBER")
	private String number;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "ZIP_CODE")
	private String zipCode;
	
	@Column(name = "CITY")
	private String city;

	public Adresse() {
		
	}
	
	public Adresse(String number, String street, String zipCode, String city) {
		super();
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adresse [number=" + number + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}

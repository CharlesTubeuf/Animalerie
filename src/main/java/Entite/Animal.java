package Entite;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ANIMAL")
public class Animal implements Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;
	
	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;
	
	@Column(name = "COULEUR")
	private String couleur; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ID_PETSTORE")
	private PetStore petStore;

	
	
	public Animal() {
		super();
	}



	public Animal(LocalDate dateNaissance, String couleur, PetStore petStore) {
		super();
		this.dateNaissance = dateNaissance;
		this.couleur = couleur;
		this.petStore = petStore;
	}



	public Animal(int id, LocalDate dateNaissance, String couleur, PetStore petStore) {
		super();
		this.id = id;
		this.dateNaissance = dateNaissance;
		this.couleur = couleur;
		this.petStore = petStore;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDate getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getCouleur() {
		return couleur;
	}



	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}



	public PetStore getPetStore() {
		return petStore;
	}



	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}



	@Override
	public String toString() {
		return "Animal [id=" + id + ", dateNaissance=" + dateNaissance + ", couleur=" + couleur + ", petStore="
				+ petStore.getName() + "]";
	}
	
	
	
}

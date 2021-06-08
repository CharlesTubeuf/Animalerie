package Entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="PETSTORE")
public class PetStore implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name; 
	
	@Column(name = "ManagerName")
	private String ManagerName;
	
	@Embedded
	@Column(name = "ADRESSE")
	private Adresse adresse;
	
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
	private Set<Animal> animals;
	
	@ManyToMany(cascade =CascadeType.PERSIST)
	@JoinTable(name = "PRODUCT_STORE", 
	joinColumns= @JoinColumn(name="ID_STORE", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_PRODUCT", referencedColumnName="ID"))
	private Set<Product> products;
	
	{
		products= new HashSet<>();
		animals= new HashSet<>();
	}
	
	
	public PetStore() {
		super();
	}
	
	public PetStore(String name, String managerName, Adresse adresse) {
		super();
		this.name = name;
		ManagerName = managerName;
		this.adresse = adresse;
	}



	public PetStore(Long id, String name, String managerName, Adresse adresse, Set<Animal> animals,
			Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		ManagerName = managerName;
		this.adresse = adresse;
		this.animals = animals;
		this.products = products;
	}

	public PetStore(String name, String managerName, Adresse adresse, Set<Animal> animals, Set<Product> products) {
		super();
		this.name = name;
		ManagerName = managerName;
		this.adresse = adresse;
		this.animals = animals;
		this.products = products;
	}

	@Override
	public String toString() {
		return "PetStore [id=" + id + ", name=" + name + ", ManagerName=" + ManagerName + ", adresse=" + adresse
				+ ", animals=" + animals + ", products=" + products + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		if (product == null) {
            return;
        }
        // this.addCompte se fait en caché lors de l'ajout du client au compte en question
        product.addPetStore(this);
	}
	
	
	
	
}

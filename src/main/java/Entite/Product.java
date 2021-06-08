package Entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "LABEL")
	private String label;
	
	@Enumerated
	@Column(name = "TYPE")
	private ProdType type;
	
	@Column(name = "PRICE")
	private double price;
	
	@ManyToMany(mappedBy = "products")
	private Set<PetStore> petStores;
	
	{
		petStores = new HashSet<>();
	}
	
	public Product() {
		super();
	}

	public Product(Long id, String code, String label, ProdType type, double price) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
	}

	public Product(String code, String label, ProdType type, double price, Set<PetStore> petStores) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
		this.petStores = petStores;
	}

	public Product(String code, String label, ProdType type, double price) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
	}
	
	public Product(Long id, String code, String label, ProdType type, double price, Set<PetStore> petStores) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
		this.petStores = petStores;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", label=" + label + ", type=" + type + ", price=" + price
				+ ", petStores=" + petStores + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ProdType getType() {
		return type;
	}

	public void setType(ProdType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<PetStore> getPetStores() {
		return petStores;
	}

	public void setPetStores(Set<PetStore> petStores) {
		this.petStores = petStores;
	}

	public void addPetStore(PetStore petStore) {
		if (petStore == null) {
            return;
        }

        //Ajout du compte dans la liste de compte du client
        petStore.getProducts().add(this);
        //Ajout du client
        this.petStores.add(petStore);
	}
	
}

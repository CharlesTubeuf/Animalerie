package Entite;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
		EntityManager em = emf.createEntityManager();
		
		Adresse adresse1 = new Adresse("11", "rue de machin", "95530", "La Frette Sur Seine");
		Adresse adresse2 = new Adresse("25", "rue de la liberté", "75000", "Paris");
		Adresse adresse3 = new Adresse("146", "rue de la marbrerie", "34510", "Vendargues");
		
		PetStore petStore1 = new PetStore("Animalus", "Nicolas", adresse1);
		PetStore petStore2 = new PetStore("Zoologia", "Pierric", adresse2);
		PetStore petStore3 = new PetStore("Magasin", "Jean", adresse3);
		
		Cat felix = new Cat("789");
		felix.setCouleur("Blanc");
		felix.setDateNaissance(LocalDate.of(2020, 1, 20));
		felix.setPetStore(petStore1);
		Cat shiva = new Cat("456");
		shiva.setCouleur("Noir");
		shiva.setDateNaissance(LocalDate.of(2020, 1, 20));
		shiva.setPetStore(petStore1);
		Cat pixelle = new Cat("123");
		pixelle.setCouleur("Ecaille de tortue");
		pixelle.setDateNaissance(LocalDate.of(2020, 1, 20));
		pixelle.setPetStore(petStore2);
		
		Fish poisson1 = new Fish(FishLivEnv.FRESH_WATER);
		poisson1.setCouleur("Noir");
		poisson1.setDateNaissance(LocalDate.of(2020, 1, 20));
		poisson1.setPetStore(petStore1);
		Fish poisson2 = new Fish(FishLivEnv.SEA_WATER);
		poisson2.setCouleur("Rouge");
		poisson2.setDateNaissance(LocalDate.of(2020, 1, 20));
		poisson2.setPetStore(petStore1);
		Fish poisson3 = new Fish(FishLivEnv.FRESH_WATER);
		poisson3.setCouleur("Noir");
		poisson3.setDateNaissance(LocalDate.of(2020, 1, 20));
		poisson3.setPetStore(petStore1);
		
		Animal chien1 = new Animal(LocalDate.of(2020, 1, 20), "Blanc", petStore1);
		Animal chien2 = new Animal(LocalDate.of(2020, 1, 20), "Noir", petStore1);
		Animal chien3 = new Animal(LocalDate.of(2020, 1, 20), "Gris", petStore2);
		
		Product product1 = new Product("123456", "Jouet os", ProdType.ACCESSORY, 9.99);
		petStore3.addProduct(product1);
		petStore2.addProduct(product1);
		petStore1.addProduct(product1);
		Product product2 = new Product("987654", "Croquette légères", ProdType.FOOD, 17.45);
		petStore1.addProduct(product2);
		Product product3 = new Product("159753", "Litière", ProdType.CLEANING, 3.20);
		petStore1.addProduct(product3);
		petStore2.addProduct(product3);
		petStore3.addProduct(product3);

		
		em.getTransaction().begin();
		em.persist(petStore1);
		em.persist(petStore2);
		em.persist(petStore3);
		em.persist(felix);
		em.persist(shiva);
		em.persist(pixelle);
		em.persist(poisson1);
		em.persist(poisson2);
		em.persist(poisson3);
		em.persist(chien1);
		em.persist(chien2);
		em.persist(chien3);
		em.getTransaction().commit();
		
		List<Animal> tousLesAnimaux = em.createQuery("SELECT a FROM Animal a JOIN a.petStore p WHERE p.id='"+petStore1.getId()+"'").getResultList();
		for(Animal a : tousLesAnimaux) {
			System.out.println(a);
		}
//		System.out.println(tousLesAnimaux.size());
		
		em.close();
		emf.close();
		
		
		
	}

}

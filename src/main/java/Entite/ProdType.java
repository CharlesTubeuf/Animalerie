package Entite;

public enum ProdType {
	FOOD("food"),ACCESSORY("accessory"),CLEANING("cleaning");
	
	private String libelle;
	
	ProdType(){
		
	}
	
	ProdType (String libelle){
		this.libelle=libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}

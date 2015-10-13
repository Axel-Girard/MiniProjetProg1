package modele;

import java.util.ArrayList;
import java.util.HashSet;

import controller.Accessoire;
import controller.Chargeur;
import controller.Coque;
import controller.Cordon;
import controller.Marque;
import controller.Telephone;
import controller.Type;

public class BaseDeDonnees {
	private ArrayList<Accessoire> accessoires;
	private ArrayList<Telephone> telephones;

	private BaseDeDonnees(){
		telephone();
		accessoire();
	}

	private void telephone() {
		telephones = new ArrayList<Telephone>();

		Telephone samsungW1 = new Telephone(40, "Samsung wave 1", (float) 125.50, "0612538966", null, new Marque("Samsung"));
		Telephone ifon5 = new Telephone(41, "Ifon 5", (float) 125.50, "0612538967", null, new Marque("ifon"));
		Telephone lgG4 = new Telephone(42, "LG G4", (float) 125.50, "0612538968", null, new Marque("LG"));

		telephones.add(samsungW1);
		telephones.add(ifon5);
		telephones.add(lgG4);
	}
	private void accessoire() {
		accessoires = new ArrayList<Accessoire>();

		Marque samsung = new Marque("Samsung");
		Marque ifon = new Marque("ifon");
		Marque lg = new Marque("LG");

		HashSet<Marque> compatibilité1 = new HashSet<Marque>();
		compatibilité1.add(samsung);
		compatibilité1.add(ifon);
		compatibilité1.add(lg);
		HashSet<Marque> compatibilité2 = new HashSet<Marque>();
		compatibilité2.add(ifon);
		HashSet<Marque> compatibilité3 = new HashSet<Marque>();
		compatibilité3.add(samsung);
		compatibilité3.add(lg);

		Chargeur c1 = new Chargeur(123, "chargeur universel", (float) 50.0, Type.secteur);
		Chargeur c2 = new Chargeur(123, "chargeur ifon", (float) 50.0, Type.secteur);
		Chargeur c3 = new Chargeur(123, "chargeur nonIfon", (float) 50.0, Type.secteur);
		c1.setMarque(compatibilité1);
		c2.setMarque(compatibilité2);
		c3.setMarque(compatibilité3);

		Coque co1 = new Coque(123, "chargeur universel", (float) 50.0, "rouge");
		Coque co2 = new Coque(123, "chargeur ifon", (float) 50.0, "vert");
		Coque co3 = new Coque(123, "chargeur nonIfon", (float) 50.0, "bleu");
		co1.setMarque(compatibilité1);
		co2.setMarque(compatibilité2);
		co3.setMarque(compatibilité3);

		Cordon cor1 = new Cordon(123, "chargeur universel", (float) 50.0, (float) 12);
		Cordon cor2 = new Cordon(123, "chargeur ifon", (float) 50.0,  (float) 15);
		Cordon cor3 = new Cordon(123, "chargeur nonIfon", (float) 50.0,  (float) 25);
		cor1.setMarque(compatibilité1);
		cor2.setMarque(compatibilité2);
		cor3.setMarque(compatibilité3);

		accessoires.add(c1);
		accessoires.add(c2);
		accessoires.add(c3);
		accessoires.add(co1);
		accessoires.add(co2);
		accessoires.add(co3);
		accessoires.add(cor1);
		accessoires.add(cor2);
		accessoires.add(cor3);
	}

	public BaseDeDonnees getInstance(){
		if(this.equals(null)){
			return new BaseDeDonnees();
		}
		else{
			return this;
		}
	}

	public ArrayList<Accessoire> getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(ArrayList<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}
}

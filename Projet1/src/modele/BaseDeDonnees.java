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

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class BaseDeDonnees {

	private static BaseDeDonnees instance = null;

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

		HashSet<Marque> compatibilite1 = new HashSet<Marque>();
		compatibilite1.add(samsung);
		compatibilite1.add(ifon);
		compatibilite1.add(lg);
		HashSet<Marque> compatibilite2 = new HashSet<Marque>();
		compatibilite2.add(ifon);
		HashSet<Marque> compatibilite3 = new HashSet<Marque>();
		compatibilite3.add(samsung);
		compatibilite3.add(lg);

		Chargeur c1 = new Chargeur(123, "chargeur universel", (float) 50.0, Type.secteur);
		Chargeur c2 = new Chargeur(124, "chargeur ifon", (float) 500.99, Type.secteur);
		Chargeur c3 = new Chargeur(125, "chargeur nonIfon", (float) 15.0, Type.secteur);
		c1.setMarque(compatibilite1);
		c2.setMarque(compatibilite2);
		c3.setMarque(compatibilite3);

		Coque co1 = new Coque(126, "coque universel", (float) 30.0, "rouge");
		Coque co2 = new Coque(127, "coque ifon", (float) 22.99, "vert");
		Coque co3 = new Coque(128, "coque nonIfon", (float) 20.0, "bleu");
		co1.setMarque(compatibilite1);
		co2.setMarque(compatibilite2);
		co3.setMarque(compatibilite3);

		Cordon cor1 = new Cordon(129, "cordon universel", (float) 12.0, (float) 12);
		Cordon cor2 = new Cordon(130, "cordon ifon", (float) 40.0,  (float) 15);
		Cordon cor3 = new Cordon(131, "cordon nonIfon", (float) 10.0,  (float) 25);
		cor1.setMarque(compatibilite1);
		cor2.setMarque(compatibilite2);
		cor3.setMarque(compatibilite3);

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

	public static BaseDeDonnees getInstance(){
		if(BaseDeDonnees.instance == null){
			return new BaseDeDonnees();
		}
		else{
			return instance;
		}
	}

	public ArrayList<Accessoire> getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(ArrayList<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}
}

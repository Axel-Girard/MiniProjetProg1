package controller;


/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class Cordon extends Accessoire {

	private float taille;

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public Cordon(int ref, String intitule, float prix, float taille) {
		super(ref, intitule, prix);
		this.taille = taille;
	}
	
	public String toString(){
		return super.toString() + " " + this.getTaille();
	}

}

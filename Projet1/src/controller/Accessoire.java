package controller;
import java.util.HashSet;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public abstract class Accessoire extends Article {

	protected  HashSet<Marque> marque;
	public Accessoire(int ref, String intitule, float prix){
		super(ref, intitule, prix);
		
		marque = new HashSet<Marque>();
	}

	public Accessoire(int ref, String intitule, float prix, HashSet<Marque> marque){
		super(ref, intitule, prix);
		
		this.marque = marque;
	}

	public HashSet<Marque> getMarque() {
		return marque;
	}

	public void setMarque(HashSet<Marque> marque) {
		this.marque = marque;
	}

	public void addMarque(Marque m){
		marque.add(m);
	}
}

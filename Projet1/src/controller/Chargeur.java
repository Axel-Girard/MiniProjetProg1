package controller;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class Chargeur extends Accessoire {
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Chargeur(int ref, String intitule, float prix, Type type) {
		super(ref, intitule, prix);
		this.type = type;
	}
	
	public String toString(){
		return super.toString() + " " + this.getType();
	}
}

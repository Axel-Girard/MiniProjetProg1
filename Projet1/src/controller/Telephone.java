package controller;

public class Telephone extends Article{
	private int numero;
	private Operateur operateur;
	private Marque marque;

	public Telephone(int ref, String intitule, float prix, int numero, Operateur operateur, Marque marque) {
		super(ref, intitule, prix);
		this.numero = numero;
		this.operateur = operateur;
		this.marque = marque;
	}

	// Getter Setter
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Operateur getOperateur() {
		return operateur;
	}
	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

}

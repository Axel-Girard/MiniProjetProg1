
public class Coque extends Accessoire {
	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Coque(int ref, String intitule, float prix, String couleur) {
		super(ref, intitule, prix);
		this.couleur = couleur;
	}
	
	public String toString(){
		return super.toString() + " " + this.getCouleur();
	}
	
}

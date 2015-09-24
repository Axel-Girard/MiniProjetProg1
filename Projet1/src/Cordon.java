
public class Cordon extends Accessoire {
	private float taille;

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public Cordon(float taille) {
		super();
		this.taille = taille;
	}
	
	public String toString(){
		return super.toString() + " " + this.getTaille();
	}

}

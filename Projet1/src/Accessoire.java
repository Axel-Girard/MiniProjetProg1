import java.util.HashSet;

public abstract class Accessoire extends Article{
	private HashSet<Marque> marque;
	public Accessoire(int ref, String intitule, float prix){
		super(ref, intitule, prix);
		
		marque = new HashSet<Marque>();
	}

	public HashSet<Marque> getMarque() {
		return marque;
	}

	public void setMarque(HashSet<Marque> marque) {
		this.marque = marque;
	}
}

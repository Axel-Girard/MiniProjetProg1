import java.util.HashSet;

public abstract class Accessoire{
	private HashSet<Marque> marque;
	public Accessoire(){
		marque = new HashSet<Marque>();
	}

	public HashSet<Marque> getMarque() {
		return marque;
	}

	public void setMarque(HashSet<Marque> marque) {
		this.marque = marque;
	}
}

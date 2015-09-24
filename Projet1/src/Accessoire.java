import java.util.HashSet;
import java.util.Set;


public abstract class Accessoire {
	private Set marque;

	public Set getMarque() {
		return marque;
	}
	public void setMarque(Set marque) {
		this.marque = marque;
	}
	public Accessoire() {
		this.marque = new HashSet();
	}
	
	
	

}

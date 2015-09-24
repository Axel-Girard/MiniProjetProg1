public class Chargeur extends Accessoire {
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Chargeur(Type type) {
		super();
		this.type = type;
	}
	
	public String toString(){
		return super.toString() + " " + this.getType();
	}
}

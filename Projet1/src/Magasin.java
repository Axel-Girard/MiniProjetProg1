
public class Magasin {

	// Classe main
	public static void main(String[] args) {
		System.out.println("Welcome in the magasin of the future of demain !");
		ListeArticles liste = new ListeArticles();
		Article a1 = new Coque(001,"coc01",(float)5.4,"Rouge");
		Article a2 = new Chargeur(002,"cha01",(float)2.3,Type.usb);
		Article a3 = new Cordon(003,"cord01",(float)5.4,(float)2);
		liste.ajouter(a1);
		liste.ajouter(a2);
		liste.ajouter(a3);
		
		liste.tousLesArticles_ParRef(false);
		
	}
}

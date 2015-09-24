import java.util.ArrayList;

public class Magasin {
	private ArrayList<Article> article;

	public Magasin(){
		article = new ArrayList<Article>();
	}

	public ArrayList<Article> getArticle() {
		return article;
	}
	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}

	// Classe main
	public static void main(String[] args) {
		System.out.println("Welcome in the magasin of the future of demain !");
	}
}

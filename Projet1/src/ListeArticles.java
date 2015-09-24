import java.util.ArrayList;

public class ListeArticles {
	private ArrayList<Article> article;

	public ListeArticles(){
		article = new ArrayList<Article>();
	}

	//Getter Setter
	public ArrayList<Article> getArticle() {
		return article;
	}
	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}

}

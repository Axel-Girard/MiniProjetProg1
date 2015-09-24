import java.util.ArrayList;
import java.util.Collections;

public class ListeArticles {
	private ArticleCompareRef compareRef;
	private ArrayList<Article> article;

	public ListeArticles(){
		article = new ArrayList<Article>();
	}

	//methodes
	// tri selon les références de l'articles
	public ArrayList<Article> tousLesArticles_ParRef(boolean croissant){
		ArrayList<Article> art = article;

		Collections.sort(art, compareRef);
		if(croissant){
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}
		else{
			Collections.reverseOrder();
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}

		return art;
	}
	
	//Getter Setter
	public ArrayList<Article> getArticle() {
		return article;
	}
	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}
}

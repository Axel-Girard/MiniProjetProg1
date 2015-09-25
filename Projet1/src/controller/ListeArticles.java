package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ListeArticles {
	private ArticleCompareRef compareRef;
	private ArticleCompareIntitule compareInt;
	private ArticleComparePrix comparePri;

	private ArrayList<Article> article;

	public ListeArticles(){
		compareRef = new ArticleCompareRef();
		compareInt = new ArticleCompareIntitule();
		comparePri = new ArticleComparePrix();
	
		article = new ArrayList<Article>();
	}

	//methodes

	// ajoute un article à la liste d'article
	public void ajouter(Article art){
		article.add(art);
	}
	// supprime un article à la liste d'article
	public void supprimer(Article art){
		article.remove(art);
	}

	// tri selon les références des articles
	public ArrayList<Article> tousLesArticles_ParRef(boolean croissant){
		ArrayList<Article> art = article;

		Collections.sort(art, compareRef);
		if(croissant){
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}
		else{
			Collections.reverse(art);
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}

		return art;
	}
	
	// tri selon les intitulé des articles
	public ArrayList<Article> tousLesArticles_ParIntitule(boolean croissant){
		ArrayList<Article> art = article;

		Collections.sort(art, compareInt);
		if(croissant){
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}
		else{
			Collections.reverse(art);
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}

		return art;
	}
	
	// tri selon les prix des articles
	public ArrayList<Article> tousLesArticles_ParPrix(boolean croissant){
		ArrayList<Article> art = article;

		Collections.sort(art, comparePri);
		if(croissant){
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}
		else{
			Collections.reverse(art);
			for(int i = 0; i < art.size(); i++){
				System.out.println(art.get(i));
			}
		}

		return art;
	}

	// methode de sauvegarde
	public void sauvegarde(){
		try {
			FileWriter fw = new FileWriter("src/sauvegarde.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(toString(),0,toString().length());
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString(){
		String str = "";
		for(int i = 0; i < article.size(); i++){
			str += article.get(i) + "\n";
		}
		return str;
	}

	//Getter Setter
	public ArrayList<Article> getArticle() {
		return article;
	}
	public void setArticle(ArrayList<Article> article) {
		this.article = article;
	}
}

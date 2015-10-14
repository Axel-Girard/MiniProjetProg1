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

	/**
	 *  ajoute un article à la liste d'article
	 * @param art l'article à ajouter
	 */
	public void ajouter(Article art){
		article.add(art);
	}
	/**
	 * supprime un article à la liste d'article
	 * @param art article à supprimer
	 */
	public void supprimer(Article art){
		article.remove(art);
	}

	/**
	 * tri selon les références des articles
	 * @param croissant désigne l'ordre croissant ou décroissant de la liste
	 * @return la liste triée par référence
	 */
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
	
	/**
	 * tri selon les intitulé des articles
	 * @param croissant désigne l'ordre croissant ou décroissant de la liste
	 * @return la liste triée par intitulé
	 */
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
	
	/**
	 * tri selon les prix des articles
	 * @param croissant désigne l'ordre croissant ou décroissant de la liste
	 * @return la liste triée par prix
	 */
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

	/**
	 *  methode de sauvegarde
	 */
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

	/**
	 * Renvoie le total de la liste d'articles
	 * @return float
	 */
	public float totalListe(){
		float total = 0;

		for(int i = 0; i < article.size(); i++){
			total += article.get(i).getPrix();
		}

		return total;
	}

	public String toString(){
		String str = "";
		for(int i = 0; i < article.size(); i++){
			str += article.get(i) + "\n";
		}
		return str;
	}

	//Getter Setter
	public ArrayList<Article> getArticles() {
		return article;
	}
	public void setArticles(ArrayList<Article> article) {
		this.article = article;
	}
	public boolean isEmpty(){
		return article.isEmpty();
	}
}

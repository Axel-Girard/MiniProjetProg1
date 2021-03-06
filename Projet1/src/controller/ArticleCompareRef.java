package controller;
import java.util.Comparator;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
public class ArticleCompareRef implements Comparator<Article> {

	public int compare(Article obj1, Article obj2) {
		int ref1 = obj1.getRef();
		int ref2 = obj2.getRef();

		if(ref1 < ref2){
			return -1;
		}
		else if (ref2 < ref1){
			return 1;
		}
		else{
			return 0;
		}
	}
}
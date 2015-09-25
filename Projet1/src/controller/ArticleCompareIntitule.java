package controller;
import java.util.Comparator;

public class ArticleCompareIntitule implements Comparator<Article> {

	public int compare(Article obj1, Article obj2) {
		String int1 = obj1.getIntitule();
		String int2 = obj2.getIntitule();
		
		return int1.compareTo(int2);
	}
}
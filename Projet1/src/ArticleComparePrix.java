import java.util.Comparator;

public class ArticleComparePrix implements Comparator<Article> {

	public int compare(Article obj1, Article obj2) {
		float pri1 = obj1.getPrix();
		float pri2 = obj2.getPrix();

		if(pri1 < pri2){
			return -1;
		}
		else if (pri2 < pri1){
			return 1;
		}
		else{
			return 0;
		}
	}
}
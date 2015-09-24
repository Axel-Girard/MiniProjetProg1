import java.util.Comparator;

public class ArticleCompareRef implements Comparator<Article> {

	public int compare(Article obj1, Article obj2) {
		int ref1 = obj1.getRef();
		int ref2 = obj2.getRef();
		if(ref1 < ref2){
			return ref1;
		}
		else{
			return ref2;
		}
	}
}
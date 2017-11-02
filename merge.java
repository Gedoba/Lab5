import java.util.ArrayList;
import java.util.List;

//merging two employee lists
public class merge{
	ArrayList mer(List A, List B){
		ArrayList ret = new ArrayList();
		ret.addAll(A);
		ret.addAll(B);
		A.clear();
		B.clear();
		return ret;
	}
}

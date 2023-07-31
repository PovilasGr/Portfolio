
import java.util.Comparator;


public class CmpPreke implements Comparator {

        @Override
	public int compare(Object x, Object y) {
		Preke o1 = (Preke) x;
		Preke o2 = (Preke) y;
		return ((Comparable)o1).compareTo(o2);
	}
}

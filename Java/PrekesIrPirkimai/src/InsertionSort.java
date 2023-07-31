import java.util.Comparator;
import java.util.List;


public class InsertionSort {        //efficient for sorting a small number of elements
    // Rusiavimas naudojant Comparator
    public void sort(List v, Comparator cmp) {
        Object val;
        int j;
        for (int i = 0; i < v.size(); i++) {
            val = v.get(i);
            j = i;
            while (j > 0 &&  cmp.compare(val, v.get(j-1)) < 0) {
                v.set(j, v.get(j-1));
                j--;
            }
            v.set(j,val);
        }
    }
    
    // Rusiavimas naudojant JavaBean klaseje esanti metoda compareTo()
    public void sort(List<Comparable> v) {
        Comparable val;
        int j;
        for (int i = 0; i < v.size(); i++) {
            val = v.get(i);
            j = i;
            while (j > 0 &&  val.compareTo(v.get(j-1)) < 0) {
                v.set(j, v.get(j-1));
                j = j - 1;
            }
            v.set(j,val);
        }
    }
}

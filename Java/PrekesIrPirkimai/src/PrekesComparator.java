import java.util.Comparator;

public class PrekesComparator  implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Preke p1 = (Preke) o1;
        Preke p2 = (Preke) o2;
        if( p1.getKodas() > p2.getKodas())
            return 1;
        else if(p1.getKodas() < p2.getKodas())
            return -1;
        else return 0;
    }
}
import java.util.Comparator;

public class PirkiniaiComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Pirkinys prk1 = (Pirkinys) o1;
        Pirkinys prk2 = (Pirkinys) o2;

        int zmId1 = prk1.getZmogausId();
        int zmId2 = prk2.getZmogausId();

        if (zmId1 > zmId2 ) return 1;
        else if (zmId1 < zmId2) return -1;
        else {
            int p1 = prk1.getPrekesId();
            int p2 = prk2.getPrekesId();
            if ( p1 > p2 ) return 1;
            else if (p1 < p2) return -1;
            else return 0;
        }
    }
}

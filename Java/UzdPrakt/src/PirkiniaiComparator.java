

import java.util.Comparator;

public class PirkiniaiComparator implements Comparator {
    // Du pirkiniai palyginami pagal du laukus: 
    // pradzioje pagal zmogausId, po to pagal prekesPav
    @Override
    public int compare(Object t1, Object t2) {
        Pirkinys prk1 = (Pirkinys) t1;
        Pirkinys prk2 = (Pirkinys) t2;
        int zm1 = prk1.getZmogausId();
        int zm2 = prk2.getZmogausId();
        if(zm1 > zm2) return 1;
        else if(zm1 < zm2) return -1;
        else { // zm1==zm2
            String p1 = prk1.getPrekesPav();
            String p2 = prk2.getPrekesPav();
            return p1.compareTo(p2);
        } 
    }
    
}

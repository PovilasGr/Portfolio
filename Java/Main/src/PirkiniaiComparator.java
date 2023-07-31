

import java.util.Comparator;

public class PirkiniaiComparator implements Comparator {
    // Du pirkiniai palyginami pagal du laukus: 
    // pradzioje pagal zmogausId, po to pagal prekesId
    @Override
    public int compare(Object t1, Object t2) {
        Pirkinys prk1 = (Pirkinys) t1;
        Pirkinys prk2 = (Pirkinys) t2;
        int zm1 = prk1.getZmogausId();
        int zm2 = prk2.getZmogausId();
        if(zm1 > zm2) return 1;
        else if(zm1 < zm2) return -1;
        else { // zm1==zm2
            int p1 = prk1.getPrekesKodas();
            int p2 = prk2.getPrekesKodas();
            if(p1 > p2) return 1;
            else if(p1 < p2) return -1;
            else return 0;
        } 
    }
    
}

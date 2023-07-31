
import java.util.*;

public class BucketSortas {
    
    public void sort(List<Preke> list, int bucketSize){  // bucketSize - vieno bucketo (LinkedList'o) dydis
        if (list.isEmpty()) {
            return;
        }

        Optional<Preke> minObj = list.stream().min(Comparator.comparing(Preke::getKodas));
        Optional<Preke> maxObj = list.stream().max(Comparator.comparing(Preke::getKodas));

        int minValue = (minObj.get()).getKodas();
        int maxValue = (maxObj.get()).getKodas();

        int bucketCount = (maxValue - minValue) / bucketSize + 1; // skaicius, kiek reikes bucketu

        LinkedList[] table = new LinkedList[bucketCount];

        // Distribute input array values into buckets
        for (int i = 0; i < list.size(); i++) {
            Preke preke = list.get(i);
            
            int index = (preke.getKodas() - minValue) / bucketSize; // bucketo indexas
            
            LinkedList bucket = table[index];

            if (bucket == null) bucket = new LinkedList();

            bucket.add(preke);

            table[index] = bucket;
        }
        print(table);

        int i = 0;
        for (List<Preke> bucket : table) {
            if(bucket != null) {

                bucket.sort(Comparator.comparing(Preke::getKodas)); //Collections.sort(bucket, cmp); // sort each bucket

                // merge the buckets back to list: O(n)
                for(Preke o : bucket) {
                    list.set(i, o);
                    i++;
                }
            }
        }
    }

    public void print(LinkedList[] table) {
        for (LinkedList bucket : table) {
            if (bucket != null) {
                System.out.print(bucket);
                System.out.println();
            }
        }
        System.out.println();
    }



    /*public Object[] raskMinMax(List list, Comparator cmp) {
        Object min = list.get(0);
        Object max = list.get(0);
        for(int i=1; i < list.size(); i++) {
            if(cmp.compare(min, list.get(i)) > 0)
                min = list.get(i);
            if(cmp.compare(max, list.get(i)) < 0)
                max = list.get(i);
        }
        Object[] rez = {min, max};
        return rez;
    }*/

}

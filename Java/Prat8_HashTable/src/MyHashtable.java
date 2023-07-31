import java.util.LinkedList;

public class MyHashtable {
    
    private LinkedList[] table;     // array of buckets for holding values
    private int size;               // number of stored values in Hashtable
    private final float loadFactorThreshold; // = [#stored values] / [#available buckets in array]
                                    // threshold after which resizing occures
                                    // usually loadFactor = 0.75

    public MyHashtable() {
        this(10, 0.75f);
    }
    
    public MyHashtable(int initialCapacity, float loadFact) {
        if(initialCapacity < 1 || loadFact <= 0) {
            System.out.println("KLAIDA: neteisinga initialCapacity arba loadFactor");
            throw new IllegalArgumentException("KLAIDA: neteisinga initialCapacity arba loadFactor");
        }
        loadFactorThreshold = loadFact;
        table = new LinkedList[initialCapacity];
    }

    public void print() {
        for (LinkedList bucket : table) {
            if (bucket != null) {
                for(Object val : bucket) {
                    System.out.print(bucketIndex(val) + ":" + val + " ");
                }
                System.out.println();
            }
        }
    }
        
    // Obtains index to the bucket for a specified value.
    private int bucketIndex(Object value) {
        if(value == null) throw new IllegalArgumentException("KLAIDA: value can't be null");
        
        int index;
        index = (value.hashCode() & 0x7FFFFFFF) % table.length; // veiksmas value.hashCode() & 0x7FFFFFFF nuima minuso zenkla nuo hash kodo
        // arba, jei table.length>1:
        //index = Math.abs(value.hashCode() % table.length);
        return index;
    }
    
    // Obtains a bucket for a specified value.
    private LinkedList bucketFor(Object value) {
        int i = bucketIndex(value); 
        LinkedList bucket = table[i];
        if (bucket == null) {
            bucket = new LinkedList();
            table[i] = bucket;
        }
        return bucket;
    }
    //obtains the appropriate bucket and the value added only if it doesn’t already exist.
    public void add(Object value) {
        LinkedList bucket = bucketFor(value);
        if (!bucket.contains(value)) {
            bucket.add(value);
            size++;
            resize();
        }
    }
    // Resizes the table to satisfy the load factor
    private void resize() {
        if(size / table.length > loadFactorThreshold) { // if loadFactor exceeded
            MyHashtable table2 = new MyHashtable(table.length * 2, loadFactorThreshold);
            for (LinkedList bucket : table) {
                if (bucket != null) {
                    for(Object o : bucket) {
                        table2.add(o);
                    }
                }
            }
            table = table2.table;
        }
    }
    
    public boolean contains(Object value) {
        int bucketIndex = bucketIndex(value);
        LinkedList bucket = table[bucketIndex];
        return bucket != null && bucket.contains(value);
    }

    public int size() {
        return size;
    }




    
    private int bucketIndexOld1(Object value) {
        String val = (String) value;
        int hash = 0;
        for(int i=0; i < val.length(); i++) {
            hash = hash + val.charAt(i);
        }
        return Math.abs(hash % table.length);
    }
    
    private int bucketIndexOld2(Object value) {
        String val = (String) value;
        int hash = 0;
        for(int i=0; i < val.length(); i++) {
            hash = hash * 31 + val.charAt(i);
        }
        return Math.abs(hash % table.length);
    }
}

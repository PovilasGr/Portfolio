
import java.util.ArrayList;
import java.util.List;

/**
 * Map implementation that uses a B-Tree
 *
 */
public class BTreeMap {
    private static final int MIN_KEYS_PER_NODE = 2; 

    private final int maxKeysPerNode;
    private Node root;
    private int size;

    public BTreeMap(int max_KeysPerNode) {
        if(max_KeysPerNode < MIN_KEYS_PER_NODE) throw new NullPointerException("maxKeysPerNode can't be < " + MIN_KEYS_PER_NODE);

        maxKeysPerNode = max_KeysPerNode;
        clear();
    }

    public Object get(Comparable key) {
        Entry entry = root.search(key);
        return entry != null ? entry.getValue() : null;
    }

    public Object set(Comparable key, Object value) {
        Object oldValue = root.set(key, value);

        if (root.isFull()) {
            Node newRoot = new Node(false);
            root.split(newRoot, 0);
            root = newRoot;
        }
        return oldValue;
    }

    public Object delete(Comparable key) {
        Entry entry = root.search(key);
        if (entry == null) {
            return null;
        }
        entry.setDeleted(true);
        size--;
        return entry.setValue(null);
    }

    public boolean contains(Comparable key) {
        return root.search(key) != null;
    }

    public final void clear() {
        root = new Node(true);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void traverse() {
        List<Entry> list = new ArrayList<>(size);
        root.traverse(list);
        
        System.out.println("------ Visi elementai -----");
        System.out.println(list);
    }
    //-------------------------------------------------------------
    
    private final class Node {
        private List<Entry> entries = new ArrayList<>(maxKeysPerNode + 1); // surusiuotas pagal key sarasas
        private List<Node> children; // list of references to child Nodes

        public Node(boolean leaf) {
            children = !leaf ? new ArrayList(maxKeysPerNode + 2) : null; //jei mazgas yra lapas, tai jo vaiku rodykles nukreipiame i null, t.y. medzio pabaiga
        }

        public boolean isFull() {
            return entries.size() > maxKeysPerNode;
        }

        private boolean isLeaf() {
            return children == null;
        }

        // TODO indexOf metoda perprogramuoti kaip "binary search", nes 'entries' yra surusiuotas sarasas
        private int indexOf(Comparable key) {
            int index = 0;

            while (index < entries.size()) {
                Entry e = entries.get(index); // imame elementa [key:value]
                int res = key.compareTo(e.getKey());

                if (res == 0) {
                    return index; // radome
                } else if (res < 0) {
                    break;
                }
                index++;
            }
            return -(index + 1); // jei nerado, grazinama pozicija, kur tikejosi rasti, tik su minuso zenklu ir dar pastumta per 1'ta (jei tikejosi surasti 0-lineje pozicijoje, kad grazintu -1, o ne 0)
        }

        public Entry search(Comparable key) {
            
            int index = indexOf(key);// ieskome, ar ArrayList'e yra toks key
            
            // jei rado key reiksme ArrayList'e, tai is karto grazinam rasta reiksme, paieska stabdome
            if (index >= 0) {
                Entry entry = entries.get(index);
                return !entry.isDeleted() ? entry : null;
            }
            // jei nerado, tada index bus lygi pozicijai, kur tikejosi rasti, tik su minuso zenklu ir dar pastumta per 1-na (jei tikejosi surasti 0-lineje pozicijoje, kad grazintu -1, o ne 0)
            // jei ne lapas, search tesiamas atitinkamame vaike
            Node n = children.get(-(index + 1));
            return !isLeaf() ? n.search(key) : null;
        }
        
        //mazgo reiksmiu splitinimas, kurio reikes atliekant insert
        public void split(Node parent, int insertionPoint) { // insertionPoint - pozicija, kur teviniame node iterpsime
            if(parent == null) throw new NullPointerException("parent can't be null");

            // dabartiniam mazgui sukuriamas brolinis mazgas 'sibling'; jei node yra lapas, tai ir brolis bus lapas
            Node sibling = new Node(isLeaf());
            
            int middle = entries.size() / 2;

            // all entries and children from midpoint are moved from node into sibling

            sibling.entries = new ArrayList<>(entries.subList(middle, entries.size()));
            entries.subList(middle, entries.size()).clear();

            if(children != null) {
                sibling.children = new ArrayList<>(children.subList(middle, children.size()));
                children.subList(middle, children.size()).clear();
            }

            // middle entry is inserted into parent
            parent.entries.add(insertionPoint, entries.remove(middle-1));

            if (parent.children.isEmpty()) {
                parent.children.add(insertionPoint, this); // this yra rodykle i sita node
            }
            parent.children.add(insertionPoint + 1, sibling);
        }
         
        public Object set(Comparable<Object> key, Object value) {
            int index = indexOf(key);
            
            //if entry with a matching key already exists, the associated value is updated, old value is returned.
            if (index >= 0) {
                return (entries.get(index)).setValue(value);
            }
            //if key was not found, it might exist in child node
            return set(key, value, -(index + 1));
        }

        // bandome ideti i vaika, bet dar patikrinam ar vaikas dar neturi tokios key:value
        private Object set(Comparable<Object> key, Object value, int index) {
            if (isLeaf()) {
                entries.add(index, new Entry(key, value));
                size++;
                return null;
            }

            Node child = (Node) children.get(index);
            Object oldValue = child.set(key, value); // griztame i anstesni set metoda

            if (child.isFull()) {
                child.split(this, index);
            }

            return oldValue;
        }
        
        public void traverse(List<Entry> list) {
            if(list == null) list = new ArrayList<>(); //throw new NullPointerException("list can't be null");
            System.out.print("[");
            
            for(Entry ent : entries) {
                if (!ent.isDeleted()) {
                    list.add(ent);
                    System.out.print(ent + " ");
                }
            }
            
            System.out.print("]");
            System.out.println();
            
            if(children != null) {
                for(Node ch : children) {
                    ch.traverse(list);
                }
                //System.out.println();
            }
        }
    }
}

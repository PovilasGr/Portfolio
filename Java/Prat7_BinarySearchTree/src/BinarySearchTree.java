import java.util.Comparator;

/**
 * binary search tree (without balancing)
 */
public class BinarySearchTree {
    private final Comparator cmp;

    private Node root; // root pagal nutylejima pradzioje priskiriama reiksme null, be to root yra private ir neturi setRoot() metodo, t.y. saknies negalima keisti, tik ja pasiimti su getRoot() metodu

    public BinarySearchTree(Comparator comparator) {
        cmp = comparator;
    }

    public Node getRoot() { // root neturi set metodo !!!, t.y. medzio saknies neleidziama keisti, ja galima tik pasiimti su getRoot() metodu
        return root;
    }
    
    /**
    1.Start at the root node.
    2. If there is no current node, the search value was not found and you are done. Otherwise, proceed to step 3.
    3. Compare the search value with the key for the current node.
    4. If the keys are equal, then you have found the search key and are done. Otherwise, proceed to step 5.
    5. If the search key sorts lower than the key for the current node, then follow the left link and go to step 2.
    6. Otherwise, the search key must sort higher than the key for the current node, so follow the right link and go to step 2.
     * @param value
     * @return 
     */
    public Node search(Object value) {
        if(value == null) {
            System.out.println("Search value can't be null. No search executed.");
            return null;
        }
        Node node = root;
        int res;
        while (node != null) {
            res = cmp.compare(value, node.getValue());
            if ( res == 0) {
                break;
            } else if ( res < 0 ) {
                node = node.getSmaller();
            } else {
                node = node.getLarger();
            }
            // 1) res = palyginame 'value' su mazge 'node' saugoma value;
            // 2) if (reiksmes yra lygios) break;
            //    else if (value yra mazesne uz mazgo value) node = node mazesnis vaikas;
            //    else node = node didesnis vaikas;
        }
        return node;
    }

    /**
     * Insertion is nearly identical to searching except that 
     * when the value doesn’t exist, it is added to the tree as a leaf node.
     * @param value
     * @return 
     */
    public Node insert(Object value) {
        if(value == null) throw new NullPointerException("Insert value can't be null");
        Node parent = null;
        Node node = root;
        int res=0;
        while (node != null) {
            parent = node;
            res = cmp.compare(value, node.getValue());
            if (res < 0) {
                node = node.getSmaller();
            } else if (res > 0) {
                node = node.getLarger();
            } else {
                System.out.println("ERROR: negalima iterpti pasikartojancios reiksmes.");
                return null;
            }
            //1) parent = dabartiniam mazgui;
            //2) res = palyginame 'value' su mazge 'node' saugoma value;
            //3) if(value yra mazesne uz mazgo value) node = node mazesnis vaikas;
            //   else if (value yra didesne uz mazgo value) node = node didesnis vaikas;
            //   else return null; // System.out.println("ERROR: negalima iterpti pasikartojancios reiksmes.");
        }

        Node newNode = new Node();
        newNode.setValue(value);
        newNode.setParent(parent);
        if ( parent == null) {
            root = newNode;
        } else if (res < 0) {
            parent.setSmaller(newNode);
        } else {
            parent.setLarger(newNode);
        }
        // sukuriame nauja tuscia mazga newNode;
        // newNode priskiriame reiksme (value);
        // newNode nurodome, kad tevinis mazgas bus (parent);
        // if (parent yra null) root = newNode;
        // else if (res < 0) teviniam mazgui parent nurodome, kad jo mazesnis vaikas bus (newNode);
        // else if (res > 0) teviniam mazgui parent nurodome, kad jo didesnis vaikas bus (newNode);

        return newNode;
    }

    // rekursyvus medzio spausdinimas
    public void printBinaryTree(Node node, int level){
        if(node==null) return;
        
        printBinaryTree(node.getLarger(), level+1);


        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");// \t yra tabuliacija (Tab)
                System.out.println("|---"+node.getValue()); //System.out.println("|-------"+node.getValue());
        } else
            System.out.println(node.getValue());


        printBinaryTree(node.getSmaller(), level+1);
    }
    
    // pereiti visus medzio elementus tokia tvarka: mazesnis vaikas -> tevas -> didesnis vaikas;
    // einant per medi spausdinti elementus ekrane; 
    // spausdins nuo maziausios reiksmes iki didziausios
    public void inOrder(Node node){
        if ( node == null) return;
        inOrder(node.getSmaller());
        System.out.println(node.getValue() + " ");
        inOrder(node.getLarger());
    }
    // pereiti visus medzio elementus tokia tvarka: didesnis vaikas -> tevas -> mazesnis vaikas;
    // einant per medi spausdinti elementus ekrane; 
    // spausdins nuo didziausios reiksmes iki maziausios
    public void inOrderRev(Node node){
        if ( node == null) return;
        inOrderRev(node.getLarger());
        System.out.println(node.getValue() + " ");
        inOrderRev(node.getSmaller());
    }
    
    public void preOrder(Node node){
        if ( node == null) return;
        System.out.println(node.getValue() + " ");
        preOrder(node.getSmaller());
        preOrder(node.getLarger());
    }

    /**
     * Three cases about the node to be deleted:
     * 1.No children (a leaf), in which case you can simply remove it.2. One child (either left or right), in which case you can replace the deleted node with its child.
     3. Two children, in which case you swap the node with its successor
     and try again with either case 1 or case 2 as appropriate.
     * @param value
     * @return
     */
    public Node delete(Object value) {
        Node node = search(value);
        if (node == null)
            return null;

        Node delNode = node;

        if(node.getSmaller() != null && node.getLarger() != null)
            delNode = node.successor();

        if(delNode == null) {
            System.out.println("ERROR: Deleted node can't be null");
            return null;
        }

        Node replacement = delNode.getSmaller() != null ? delNode.getSmaller() : delNode.getLarger();

        if (replacement != null) {
            replacement.setParent(delNode.getParent());
        }

        if (delNode == root) {
            root = replacement;
        } else if (delNode.isSmaller()) {
            delNode.getParent().setSmaller(replacement);
        } else {
            delNode.getParent().setLarger(replacement);
        }

        if (delNode != node) {
            Object deletedValue = node.getValue();
            node.setValue(delNode.getValue());
            delNode.setValue(deletedValue);
        }

        return delNode;
    }
}

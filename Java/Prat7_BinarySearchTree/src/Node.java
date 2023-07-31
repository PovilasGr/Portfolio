
public class Node {
    private Object value;
    private Node parent;
    private Node smaller;
    private Node larger;

    public Node() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getSmaller() {
        return smaller;
    }

    public void setSmaller(Node smaller) {
        this.smaller = smaller;
    }

    public Node getLarger() {
        return larger;
    }


    public void setLarger(Node larger) {
        this.larger = larger;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    // returns node with mim value starting from this node
    public Node minimum() {
        Node node = this;
        while (node.getSmaller() != null) {
            node = node.getSmaller();
        }
        return node;
    }

    // returns node with max value starting from this node
    public Node maximum() {
        Node node = this;
        while (node.getLarger() != null) {
            node = node.getLarger();
        }
        return node;
    }

    // is it a smaller child of its parent
    public boolean isSmaller() {
        return getParent() != null && this == getParent().getSmaller();
    }

    // is it a larger child of its parent
    public boolean isLarger() {
        return getParent() != null && this == getParent().getLarger();
    }
    
    // return node with next largest value starting from this node
    // 1) if node has a right child then successor is the minimum of that.
    // 2) if node has no right child then 
    //    search back up the tree until the first “right-hand turn.”
    public Node successor() {
        if (getLarger() != null) {
            return getLarger().minimum();
        }
        Node node = this;
        while (node.isLarger()) {
            node = node.getParent();
        }
        return node.getParent();
    }
    
    // return node with next smallest value starting from this node
    // 1) if node has a left child then predecessor is the maximum of that.
    // 2) if node has no left child then 
    //    search back up the tree until the first “left-hand turn.”    
    public Node predecessor() {
        if (getSmaller() != null) {
            return getSmaller().maximum();
        }
        Node node = this;
        while (node.isSmaller()) {
            node = node.getParent();
        }
        return node.getParent();
    }
}

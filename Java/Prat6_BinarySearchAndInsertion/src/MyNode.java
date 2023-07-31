
public class MyNode {
     
    private Object value;
    private MyNode previous;
    private MyNode next;
    private int binSearchIndex = -1;

    public MyNode(Object val) {
        value = val;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public MyNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode previous) {
        if(previous == null) {
            throw new NullPointerException("KLAIDA: previous negali buti null");
        }
        this.previous = previous;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        if(next == null) {
            throw new NullPointerException("KLAIDA: next negali buti null");
        }
        this.next = next;
    }

    public int getBinSearchIndex() {
        return binSearchIndex;
    }

    public void setBinSearchIndex(int binSearchIndex) {
        this.binSearchIndex = binSearchIndex;
    }

    /**
     * Insert itself into the list before another element
     * @param elem
     */
    public void attachBefore(MyNode elem) {
        MyNode previousElem = elem.getPrevious();
        
        // permetame next/previous rodykles
        this.setNext(elem);
        this.setPrevious(previousElem);
        
        elem.setPrevious(this);
        previousElem.setNext(this);
    }
    
    /**
     * Remove itself from the list
     */
    public void detach() {
        // permetame next/previous rodykles
        previous.setNext(next);
        next.setPrevious(previous);
    }
    
}

/**
 * List - collection of elements supporting random access to each element.
 * List preserves insertion order.
 * List may contain duplicate values.
 * List can resize: grow or shrink as elements are added or deleted.
 * 
 * Doubly Linked List contains elements with links to the next and previous elements.
 * Double linking makes possible to traverse list in either direction.
 * When inserting/deleting element you only need to update links to the next and from previous elements.
 * This makes cost of insertion/deletion negligible.
 * On the other hand traversal of list is time consuming.
**/

public class MyLinkedList implements MyList {
    
    // headAndTail - sentinel (or null object) points to the first and from the last elements of list.
    // Sentinel is used to denote the start and the end of the list.

    private final MyNode headAndTail = new MyNode(null); // final, i.e. unmodifiable

    private int size;   //size of list, initializes to 0

    public MyLinkedList() {
        // Pradzioje sukuriamas tik headAndTail elementas, kurio next/previous rodykles rodo i save
        headAndTail.setPrevious(headAndTail);
        headAndTail.setNext(headAndTail);
        size = 0;                // empty the list
    }

    /**
     * Obtains element for a specified position "index" 
     * starting at the first element and forwards
     * or starting at the last element and backwards.
     */
    private MyNode getElement(int index) {
        if(index < 0 || index > size()){ // demesio: leidziamas atvejis index == size(), kad butu galima iterpti pries 'tail' elementa
            throw new IndexOutOfBoundsException();
        }
        MyNode element = headAndTail;
        if(size > 0) {
            if(index < size/2) {
                for (int i = 0; i < index+1; i++) {
                    element = element.getNext();
                }
            } else {
                for (int i = size - index; i > 0; i--) {   
                    element = element.getPrevious();
                }
            }
        }
        return element;
    }
    
    /**
     * Inserts value at position index
     * @param index
     * @param value
     */
    @Override
    public void add(int index, Object value) {
        if(value == null) {
            throw new NullPointerException();
        }
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode element = new MyNode(value);
        element.attachBefore(getElement(index));
        size++;
    }

    /**
     * Adds new element at the end of list
     * @param value
     */
    @Override
    public void add(Object value) {
        add(size(), value);
    }

    /**
     * Deletes element at position index
     * @param index
     */
    @Override
    public Object remove(int index) {
        if(index < 0 || index > size() - 1){
            throw new IndexOutOfBoundsException();
        }
        MyNode element = getElement(index);
        element.detach();
        size--;
        return element.getValue();
    }

    /**
     * Deletes the first found element with given value
     */
    @Override
    public boolean remove(Object value) {
        if(value == null) {
            throw new NullPointerException();
        }

        for (MyNode e = headAndTail.getNext(); e!=headAndTail; e=e.getNext()){
            if (value.equals(e.getValue())) {                                   // ziureti Preke javabean klase equals() metoda
                e.detach();
                size--;
                return true;         // jei triname tik pirma surasta elementa
            }
        }
        return false;
    }

    // Delete all elements from the list, except headAndTail
    @Override
    public void clear() {
        headAndTail.setPrevious(headAndTail);
        headAndTail.setNext(headAndTail);
        size = 0;
    }

    // Set value at position index
    @Override
    public Object set(int index, Object value) {
        if(value == null) {
            throw new NullPointerException();
        }
        if(index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException();
        }
        MyNode element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    // Get value at position index
    @Override
    public Object get(int index) {
        if(index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException();
        }
        return getElement(index).getValue();
    }

    // Position of value in the list (first occurence)
    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException();
        }
        int index = 0;

        for (MyNode e = headAndTail.getNext(); e != headAndTail; e = e.getNext()) {
            if (value.equals(e.getValue())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /*private static final class MyNode {
        //MyNode klase turetu buti aprasyta kaip "private static final" MyLinkedList viduje
        //bet paprastumo delei ja sukureme atskirai...
    }*/
}

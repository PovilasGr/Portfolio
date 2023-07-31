/**
 * List - collection of elements supporting random access to each element.
 * List preserves insertion order.
 * List may contain duplicate values.
 * List can resize: grow or shrink as elements are added or deleted.
**/

public interface MyList {
    
    public void add(int index, Object value);
    public void add(Object value);                      //Adds a value to the end of the list
    public Object remove(int index);
    public boolean remove(Object value);
    public void clear();                                // Deletes all elements from the list
    public Object set(int index, Object value);
    public Object get(int index);
    public int indexOf(Object value);
    public boolean contains(Object value);
    public int size();
    public boolean isEmpty();
}
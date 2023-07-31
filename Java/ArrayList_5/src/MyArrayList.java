import java.util.Arrays;
import java.util.List;

/**
 * A {@link List} implementation that uses an array as the mechanism for storing elements.
 *
 */

public class MyArrayList implements MyList {
    /**
     * The maximum length of array to allocate (unless necessary).
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * {@code OutOfMemoryError: Requested array size exceeds VM limit}
     */
    public static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    private static final int DEFAULT_CAPACITY = 10;

    private int initialCapacity;
    private Object[] elementData;
    private int size;                   // number of stored values

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 1 || initialCapacity > MAX_ARRAY_LENGTH) {
            throw new IllegalArgumentException("Illegal initialCapacity: " + initialCapacity);
        }

        this.elementData = new Object[initialCapacity];
        this.initialCapacity = initialCapacity;
    }

    /**
     * Adds element/object 'value' at the position index
     * @param index
     * @param value
     */
    
    @Override
    public void add(int index, Object value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);  //(Object src, int srcPos, Object dest, int destPos, int length)
        elementData[index] = value;
        size++;
    }

    @Override
    public void add(Object value) {
        add(size(), value);
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Delete element at the position index
     * @param index
     * @return deleted value
     */
    @Override
    public Object remove(int index) {
        checkOutOfBounds(index);
        Object value = elementData[index];
        int copyFromIndex = index + 1;
        if (copyFromIndex < size) {
            System.arraycopy(elementData, copyFromIndex, elementData, index, size - copyFromIndex); //(Object src, int srcPos, Object dest, int destPos, int length)
        }
        elementData[--size] = null;
        return value;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Given value is written in position index
     * @param index
     * @param value
     * @return
     */
    @Override
    public Object set(int index, Object value) {
        checkOutOfBounds(index);
        Object oldValue = elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public Object get(int index) {
        checkOutOfBounds(index);
        return elementData[index];
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void trimToSize() {
        if (size < elementData.length)
            elementData = Arrays.copyOf(elementData, size);
    }

    /**
     * Ensures the internal array is large enough to accommodate a specific number of elements.
     * Jei masyve pritruksta vietos, sukuriamas 50% didesnis masyvas ir i ji perkopijuojami duomenys is seno masyvo
     * 
     * @param minCapacity The number of elements to support.
     */
    private void ensureCapacity(int minCapacity) {
        if(minCapacity < 1) {
            throw new IllegalArgumentException("Illegal capacity.");
        }
        int oldCapacity = elementData.length;

        if (oldCapacity < minCapacity) {

            int minGrowth   = minCapacity - oldCapacity;
            int prefGrowth  = oldCapacity / 2; // t.y. padidintume 50%
            int newCapacity = oldCapacity + Math.max(minGrowth, prefGrowth); // padidiname arba 50%, arba jei 50% per mazai, tada padidiname per minGrowth

            if (newCapacity > MAX_ARRAY_LENGTH) {
                newCapacity = MAX_ARRAY_LENGTH;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }


    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    /*private boolean isOutOfBounds(int index) {
        return index < 0 || index >= size();
    }*/
}
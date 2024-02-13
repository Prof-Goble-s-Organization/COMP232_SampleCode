package structures.objects;

/**
 * An implementation of the CS132List interface backed with an array of Objects.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public class COMP132ArrayList implements COMP132List{
    private static final int INITIAL_CAPACITY = 10;

    private Object[] listElements;
    private int currentSize;

    /**
     * Construct a new ArrayBackedList
     */
    public COMP132ArrayList() {
        listElements = new Object[INITIAL_CAPACITY];
        currentSize = 0;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return currentSize;
    }

    /**
     * {@inheritDoc}
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                        + " but size is " + currentSize);
        } else {
            return listElements[index];
        }
    }

    public void set(int index, Object element) throws IndexOutOfBoundsException{
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to set " + index 
                        + " but is size " + currentSize);
        } else {
            listElements[index] = element;
        }
    }

    /**
     * @param element 
     *          the Object to append to the list
     */
    public void add(Object element) {
        // if the array is full, double its size
        if (currentSize == listElements.length) {
            doubleArraySize();
        }

        listElements[currentSize] = element;
        currentSize++;
    }

    /**
     * Double the size of the array that is holding the list elements and 
     * copy the current list into the new array.
     */
    public void doubleArraySize() {
        Object[] temp = new Object[listElements.length * 2];
        System.arraycopy(listElements, 0, temp, 0, listElements.length);
        listElements = temp;
    }

    /**
     * Insert the specified element at the specified index. All objects at the 
     * specified index and higher will be shifted up one index in the underlying 
     * array. 
     * If the array is full, a new array with twice the capacity will be created, 
     * all of the elements will be copied into the new array and then the new 
     * element will be inserted.
     * 
     * @param index
     *          The index at which to insert the new object
     * @param element
     *          The object to be inserted
     * @throws IndexOutOfBoundsException
     *          if index < 0 || index >= size()
     */
    public void insert(int index, Object element) throws IndexOutOfBoundsException {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index + "but size is " + currentSize);
        } else {
            // If the array is full, double its size
            if (currentSize == listElements.length) {
                doubleArraySize();
            }

            /*
             * Shift each of the elements at index or higher up by one location
             * to make room for the new element to be inserted
             */
            for (int i = currentSize; i > index; i--) {
                listElements[i] = listElements[i - 1];
            }

            // insert the new element
            listElements[index] = element;
            currentSize++;
        }
    }

    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                        + " but size is " + currentSize);
        } else {
            Object target = listElements[index];

            /*
             * Shift each of the elements at index or higher down by one 
             * location to fill in the hole left by the removal of the element 
             * at index
             */
            for (int i = index; i < currentSize - 1; i++) {
                listElements[i] = listElements[i + 1];
            }

            // make sure we don't have two references to the last element 
            // in the list
            listElements[currentSize - 1] = null;
            currentSize--;

            return target;
        }
    }
}

package structures.generic;

/**
 * An implementation of myList interface backed with an array of objects
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 12 2024
 */
public class MyArrayList<E> implements MyList<E> {
    public static final int INITIAL_CAPACITY = 10;
    private E[] listElements;
    private int currentSize;

    /**
	 * Construct a new ArrayBackedList.
	 */
    public MyArrayList() {
        /*
		 * NOTE: Java does not support the creation of arrays of a generic type.
		 * So instead we create an array of type Object and cast it to the
		 * appropriate type.
		 */
        listElements = (E[]) new Object[INITIAL_CAPACITY];
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
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            return listElements[index];
        }
    }

    /**
	 * {@inheritDoc}
	 */
    public void set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to access " + index 
                           + " but size is " + currentSize);
        } else {
            listElements[index] = element;
        }
    }

    /**
	 * Append the specified Object to the end of the list. The size of the list
	 * is increased by 1. If the list is full, a new array with twice the
	 * capacity will be created, all of the elements will be copied into the new
	 * array and then the new element will be added to the end.
	 * 
	 * @param element
	 *            the Object to append to the list.
	 */
    public void add(E element) {
        // If the array is full double its size.
        if (currentSize == listElements.length) {
            doubleCapacity();
        }

        listElements[currentSize] = element;
        currentSize++;
    }

    /*
	 * Double the size of the array that is holding the list elements and copy
	 * the current list into the new array.
	 */
    private void doubleCapacity() {
        E[] temp = (E[]) new Object[listElements.length * 2];
        System.arraycopy(listElements, 0, temp, 0, listElements.length);
        listElements = temp;
    }

    /**
	 * Insert the specified element at the specified index. All objects at the
	 * specified index and higher will be shifted up one index in the underlying
	 * array. If the array is full, a new array with twice the capacity will be
	 * created, all of the elements will be copied into the new array and then
	 * the new element will be inserted.
	 * 
	 * @param index
	 *            the index at which to insert the new object.
	 * @param element
	 *            the object to be inserted.
	 * @throws IndexOutOfBoundsException
	 *             if index < 0 or index >= size()
	 */
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            // If the array is full double its size.
            if(currentSize == listElements.length) {
                doubleCapacity();
            } 

            /*
			 * Shift each of the elements at index or higher up by one location
			 * to make room for the new element to be inserted.
			 */
            for(int i = 0; i > index; i--) {
                listElements[i] = listElements[i - 1];
            }

            // Insert the new element.
            listElements[index] = element;
            currentSize++;
        }
    }

    /*
	 * Half the size of the array that is holding the list elements and copy the
	 * current list into the new array.
	 */
    private void halfCapacity() {
        E[] temp = (E[]) new Object[listElements.length / 2];
        System.arraycopy(listElements, 0, temp, 0, currentSize);
        listElements = temp;
    }

    /**
	 * {@inheritDoc}
	 */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            // If the array is less than 1/3 full, half its size.
            if (listElements.length > INITIAL_CAPACITY 
                        && currentSize < listElements.length / 3) {
                halfCapacity();
            }

            E el = listElements[index];

            /*
			 * Shift each of the elements at index or higher down by one
			 * location to fill in the hole left by the removal of the element
			 * at index.
			 */
            for (int i = index; i < currentSize - 1; i++) {
                listElements[i] = listElements[i+1];
            }

            // Make sure we don't have two references to the last element in the
			// list.
            listElements[currentSize - 1] = null;
            currentSize--;

            return el;
        }
    }
}

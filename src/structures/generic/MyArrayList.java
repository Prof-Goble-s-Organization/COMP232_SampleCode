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

    public MyArrayList() {
        listElements = (E[]) new Object[INITIAL_CAPACITY];
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            return listElements[index];
        }
    }

    public void set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to access " + index 
                           + " but size is " + currentSize);
        } else {
            listElements[index] = element;
        }
    }

    public void add(E element) {
        if (currentSize == listElements.length) {
            doubleCapacity();
        }

        listElements[currentSize] = element;
        currentSize++;
    }

    private void doubleCapacity() {
        E[] temp = (E[]) new Object[listElements.length * 2];
        System.arraycopy(listElements, 0, temp, 0, listElements.length);
        listElements = temp;
    }

    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            if(currentSize == listElements.length) {
                doubleCapacity();
            } 

            for(int i = 0; i > index; i--) {
                listElements[i] = listElements[i - 1];
            }

            listElements[index] = element;
            currentSize++;
        }
    }

    private void halfCapacity() {
        E[] temp = (E[]) new Object[listElements.length / 2];
        System.arraycopy(listElements, 0, temp, 0, currentSize);
        listElements = temp;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index 
                            + " but size is " + currentSize);
        } else {
            if (listElements.length > INITIAL_CAPACITY 
                        && currentSize < listElements.length / 3) {
                halfCapacity();
            }

            E el = listElements[index];

            for (int i = index; i < currentSize - 1; i++) {
                listElements[i] = listElements[i+1];
            }

            listElements[currentSize - 1] = null;
            currentSize--;

            return el;
        }
    }
}

package hashing.list;

/**
 * Generic List interface that defines the operations supported by all 
 * of the implementations of the List ADT
 * 
 * @author William Goble
 * @author Dickinson College
 * @version April 8, 2024
 */
public interface List<E> {
    /**
     * Get the current size of the list
     * 
     * @return the size
     */
    public int size();

    /**
     * Append the specified element to the end of the list. The size
     * of the list is increased by 1.
     * 
     * @param element
     *      The data element to append to the list
     */
    public void add(E element);

    /**
     * Get the data element stored at the specified index of the list
     * 
     * @param index
     *      The index from which to get the element
     * @return
     *      The data element at the index
     * @throws IndexOutOfBoundsException
     *      If index < 0 or index >= size()
     */
    public E get(int index) throws IndexOutOfBoundsException;

    /**
     * Replace the data at the specified index with the specified Object
     * 
     * @param index
     *      The index of the element to be replaced
     * @param element
     *      The new data element to store at the index
     * @throws IndexOutOfBoundsException
     *      If index < 0 or index >= size()
     */
    public void set(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Insert the specified data element before the one found at index. The 
     * newly inserted data element will now be found at the specified index. All 
     * elements at index and higher will have their index increased by one.
     * 
     * Note: It is possible to insert at the end of a list by giving an index 
     * equal to the size.
     * 
     * @param index
     *      The index at which to insert the new element
     * @param element
     *      The new data element to be inserted
     * @throws IndexOutOfBoundsException
     *      If index < 0 or index >= size()
     */
    public void insert(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Remove and return the data element at the specified index. All elements 
     * at index and higher have their index decreased by one.
     * 
     * @param index
     *      The index from which to remove the element
     * @return
     *      The element found at index
     * @throws IndexOutOfBoundsException
     *      If index < 0 or index >= size()
     */
    public E remove(int index) throws IndexOutOfBoundsException;
}
package hashing.list;

/**
 * Interface implementation by objects returned by ADTs that implement 
 * Iterable
 * 
 * @author William Goble
 * @author Dickinson College
 * @version April 8, 2024
 */
public interface Iterator<E> {
    /**
     * Check if there is at least one element that can be retrieved by a call 
     * to next.
     * 
     * @return
     *      true if next will return an element.
     *      false otherwise
     */
    public boolean hasNext();

    /**
     * Get the next element in the structure and advance the iterator. Successive 
     * calls to next will traverse all elements of the structure. 
     * 
     * Note: Alternating calls to next and previous will return the same element
     * 
     * @return
     *      the next element of the structure
     * @throws NoSuchElementException
     *      If there is no next element to be returned
     */
    public E next();

    /**
     * Check if there is at least one element that can be retrieved by a call 
     * to previous
     * 
     * @return
     *      true if previous will return an element
     *      false otherwise
     */
    public boolean hasPrevious();

    /**
     * Get the previous element in the structure and move the iterator backwards 
     * in the structure. Successive calls to previous will traverse all elements 
     * of the strucutre in the opposite order of next.
     * 
     * Note: Alternating calls to next and previous will return the same element
     * 
     * @return
     *      The previous element in the structure
     * @throws NoSuchElementException
     *      If there is no previous element to be returned
     */
    public E previous();

    /**
     * Insert an element into the structure. The new element is inserted 
     * immediately before the element that would be returned by next(), if any, 
     * and/or after the element that would be returned by previous(), if any. 
     * If the structure contains no elements, the new element becomes the sole 
     * element in the structure. If the iterator has reached the end of the 
     * structure then the new element becomes the last element in the structure.
     * 
     * Note: The element that would be returned by next is unaffected by insert 
     * and a call to previous following an insert will return the inserted element
     * 
     * @param element
     *      The element to be inserted into the sturcture
     */
    public void insert(E element);

    /**
     * Removes from the list the last element that was returned by next() or 
     * previous(). This call can only be made <i>once</i> per call to next or 
     * previous. 
     * 
     * @return 
     *      The element that was removed from the structure.
     * @throws IllegalStateException
     *      If next or previous have not be called since the last call to remove.
     */
    public E remove();
}

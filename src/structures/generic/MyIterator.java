package structures.generic;

/**
 * Interface implemented by objects returned by ADTs that implement 
 * myIterable
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 12, 2024
 */
public interface MyIterator<E> {
    /**
     * Check if there is at least one more element that can be retrieved by a 
     * call to next.
     * 
     * @return 
     *          True if next will return an element, false otherwise.
     */
    public boolean hasNext();

    /**
     * Get the next element in the structure and advance the iterator. 
     * Successive calls to next will traverse all elements of the structure.
     * 
     * N.B. Alternating calls to next and previous will return the same element
     * @return
     *          The next element in the structure
     * @throws NoSuchElementException
     *          If there is no next element to be returned (i.e. hasNext 
     *          returns false).
     */
    public E next();

    /**
     * Check if there is at least one more element that can be retrieved by a 
     * call to previous
     * 
     * @return
     *      true if previous will return an element, false otherwise
     */
    public boolean hasPrevious();

    /**
     * Get the previous element in the structure and move the iterator backwards 
     * in the structure. Successive calls to previous will traverse all elements 
     * of the structure in the opposite order to next. 
     * 
     * N.B Alternating calls to next and previous will return the same element
     * 
     * @return
     *          The previous element in the structure
     * @throws NoSuchElementException
     *          If there is no previous element to be removed (i.e. hasPrevious 
     *          returns false.)
     */
    public E previous();

    /**
     * Insert an element into the structure. The new element is inserted 
     * immediately before the element that would be returned by next(), if any,
     * and/or after the element that would be returned by previous(), if any. 
     * If the structure contains no elements, the new element becomes the sole 
     * element in the structure. If the iterator has reached the end of the  
     * structure (i.e. hasNext returns false) then the new element becomes the 
     * last element in the structure (and hasNext still returns false).
     * 
     * N.B The element that would be returned by next is unaffected by an insert 
     * and a call to previous following an insert will return the inserted element.
     * 
     * @param element
     *          The element to be inserted into the structure
     */
    public void insert(E element);

    /**
     * Removes from the list the last element that was returned by next() or 
     * previous(). This call can only be made once per callto next or previous. 
     * 
     * @return
     *          The element that was removed from the structure.
     * @throws IllegalStateException
     *          if next or previous have not been called since the last call to 
     *          remove.
     */
    public E remove();
}

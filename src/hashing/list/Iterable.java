package hashing.list;

/**
 * Interfaced used by an ADT to indicate that an Iterator can be obtained for 
 * the data structure.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version April 8, 2024
 */
public interface Iterable<E> {
    /**
     * Get an Iterator for the elements of this data structure.
     * 
     * @return
     *      An Iterator for the data structure
     */
    public Iterator<E> getIterator();
}

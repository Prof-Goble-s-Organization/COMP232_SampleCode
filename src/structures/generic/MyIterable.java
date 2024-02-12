package structures.generic;

/**
 * Interface used by an ADT to indicate that a myIterator can be obtained for 
 * the data structure
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 7, 2024
 */
public interface MyIterable<E> {
    /**
     * Get a myIterator for the elements of this data structure
     * 
     * @return 
     *      A myIterator for the data structure
     */
    public MyIterator<E> getIterator();
}
